package com.exp.zsq.juc.executor.forkjoin.FjApp;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.lhjc.base.cache.MemeryCache;
import com.lhjc.base.exception.BusinessException;
import com.lhjc.base.service.BaseService;
import com.lhjc.base.service.bean.PageList;
import com.lhjc.base.util.Global;
import com.lhjc.tj.controller.bean.ConfigBusiness;
import com.lhjc.tj.controller.bean.LoginInfo;
import com.lhjc.tj.dict.ConfigType;
import com.lhjc.tj.dict.MemeryCacheKay;
import com.lhjc.tj.lucene.init.DiseaseIndex;
import com.lhjc.tj.service.config.business.ConfigImpl;
import com.lhjc.tj.service.dept.business.DeptImpl;
import com.lhjc.tj.service.dept.pojo.Dept;
import com.lhjc.tj.service.disease.mapper.DiseaseMapper;
import com.lhjc.tj.service.disease.pojo.Disease;
import com.lhjc.tools.PinyinAPI;
import com.lhjc.tools.UtilAPI;
import com.lhjc.tools.WuBiAPI;
import com.opensymphony.oscache.base.NeedsRefreshException;

@Service
public class DiseaseImpl extends BaseService<Disease, DiseaseMapper> {
	@Autowired
	private DiseaseMapper diseaseMapper;

	@Autowired
	private DeptImpl deptImpl;

	@Autowired
	private MemeryCache memeryCache;
	@Autowired
	private ConfigImpl configImpl;

	/**
	 * 查询所有基本数据（缓存）
	 *
	 * @return
	 */
	public List<Disease> findAllDisease() {
		List<Disease> listDisease = new ArrayList<Disease>();
		try {
			listDisease = (ArrayList<Disease>) memeryCache.get(MemeryCacheKay.DISEASE);
		} catch (NeedsRefreshException e) {
			listDisease = this.diseaseMapper.findAllDisease();
			memeryCache.put(MemeryCacheKay.DISEASE, listDisease);
		}
		return listDisease;
	}

	/**
	 * 科室录入，疾病关键字反向检索
	 * @param keywords 客户端结果关键字
	 * @return
	 */
	public List<Map<String, Object>> reverseSearch(Integer sex, String... searchContent) {
		List<Disease> diseCacheList = this.findAllDisease();
		DiseaseTask dtask = new DiseaseTask(diseCacheList, 0, diseCacheList.size() - 1);
		// 并行任务数量
		int threshold = 20;
		// 线程数
		int nThreads = 10;
		DiseaseForkJoin dfj = new DiseaseForkJoin(dtask, threshold, searchContent, sex);
		ForkJoinPool fjPool = new ForkJoinPool(nThreads);
		fjPool.invoke(dfj);
		List<Map<String, Object>> listMap = dfj.getDiseMapList();
		// 去重
		for (int i = 0; i < listMap.size() - 1; i++) {
			for (int j = listMap.size() - 1; j > i; j--) {
				String diseName1 = UtilAPI.turnString(listMap.get(j).get("disease_name"));
				String diseName2 = UtilAPI.turnString(listMap.get(i).get("disease_name"));
				if (diseName1.contains(diseName2)) {
					listMap.remove(i);
					i--;
					break;
				} else if (diseName2.contains(diseName1)) {
					listMap.remove(j);
				}
			}
		}
		return listMap;
	}

	/** 疾病库分页查询List<Bean> */
	public PageList<Disease> list(Disease query) throws BusinessException {
		return this.selectPageSize(query, query.getCurPage(), query.getPageSize());
	}

	/** 疾病库分页查询List<Map<String,Object>> */
	public PageList<Map<String, Object>> listMap(Disease query) throws BusinessException {
		return this.selectMapPageSize(query, query.getCurPage(), query.getPageSize());
	}

	/**
	 * 疾病库增加
	 *
	 * @throws IOException
	 */
	public void insert(Disease disease) throws BusinessException, IOException {
		this.diseaseMapper.insert(disease);
		// 删除缓存
		memeryCache.remove(MemeryCacheKay.DISEASE);
		// lucene 更新
		DiseaseIndex dtools = new DiseaseIndex();
		dtools.updateIndex(disease);
	}

	/**
	 * 疾病库修改
	 *
	 * @throws IOException
	 */
	public void update(Disease disease) throws BusinessException, IOException {
		this.diseaseMapper.update(disease);
		// lucene 更新
		DiseaseIndex dtools = new DiseaseIndex();
		dtools.updateIndex(disease);
		// 删除缓存
		memeryCache.remove(MemeryCacheKay.DISEASE);
	}

	/**
	 * 疾病库 根据ID删除
	 *
	 * @throws IOException
	 */
	public void deleteById(Long id) throws BusinessException, IOException {
		if (UtilAPI.isNull(id)) {
			throw new BusinessException("ID不能为空");
		}
		this.diseaseMapper.deleteById(id);
		// 删除缓存
		memeryCache.remove(MemeryCacheKay.DISEASE);
		// lucene 删除
		DiseaseIndex dtools = new DiseaseIndex();
		dtools.deleteIndex(id);
	}

	/**
	 * 疾病库 根据ID修改为无效数据
	 *
	 * @throws IOException
	 */
	public void updateFlagInvalid(Long id) throws BusinessException, IOException {
		if (UtilAPI.isNull(id)) {
			throw new BusinessException("ID不能为空");
		}
		this.diseaseMapper.updateFlagInvalid(id);
		// 删除缓存
		memeryCache.remove(MemeryCacheKay.DISEASE);
		// lucene 删除
		DiseaseIndex dtools = new DiseaseIndex();
		dtools.deleteIndex(id);
	}

	/** 疾病库 根据ID查询数据 */
	public Disease findById(Long id) throws BusinessException {
		if (UtilAPI.isNull(id)) {
			throw new BusinessException("ID不能为空");
		}
		return this.diseaseMapper.findById(id);
	}

	/**
	 * 构建总检建议
	 *
	 * @param medical_id
	 * @return
	 */
	public String createSuggest(Long medical_id,String old_suggest) throws Exception {
		ConfigBusiness configbusiness = this.configImpl.findConfig(new ConfigBusiness(), ConfigType.CONFIG_BUSINESS, Global.COMMON);
		StringBuilder sbStr = new StringBuilder();
		int rows = 1;
		List<Disease> listDisease = this.diseaseMapper.findDiseaseByMedicalId(medical_id);
		List<Disease> newListDisease = new ArrayList<>();
		if(!UtilAPI.isNull(old_suggest)){
			for(int i=0;i<listDisease.size();i++){
				if(old_suggest.indexOf(listDisease.get(i).getDisease_name())>0){
					rows++;
				}else{
					newListDisease.add(listDisease.get(i));
				}
			}
			if(old_suggest.indexOf(configbusiness.getDefault_suggest())>0){
				old_suggest = old_suggest.replaceAll(configbusiness.getDefault_suggest(), "");
			}
			sbStr.append(old_suggest);
		}else{
			newListDisease=listDisease;
		}

		for (int i = 0; i < newListDisease.size(); i++) {
			String diseaseName = newListDisease.get(i).getDisease_name();
			String suggest_content = newListDisease.get(i).getSuggest_content();
			String disease_explain = newListDisease.get(i).getDisease_explain();
			sbStr.append(rows).append("、【").append(diseaseName+"】");
			if (!UtilAPI.isNull(suggest_content)) {
				if(!UtilAPI.isNull(configbusiness.getIs_create_disease_explain())){
					if(configbusiness.getIs_create_disease_explain().equals("1")){
						if(!UtilAPI.isNull(disease_explain)){
							sbStr.append("\r\n疾病解释：\r\n");
							sbStr.append(UtilAPI.turnString(disease_explain));
						}
						sbStr.append("\r\n疾病建议：");
					}
				}
				sbStr.append("\r\n");
				sbStr.append(UtilAPI.turnString(suggest_content));
				sbStr.append("\r\n");
			}
			sbStr.append("\r\n");
			rows++;
		}

		if (!UtilAPI.isNull(configbusiness.getDefault_suggest())) {
			sbStr.append(configbusiness.getDefault_suggest());
		}
		return sbStr.toString();
	}

	/***
	 * 根据体检ID查询疾病
	 *
	 * @param turnLong
	 * @return
	 */
	public List<Disease> findByMedicalId(long medical_id) {
		return this.diseaseMapper.findDiseaseByMedicalId(medical_id);
	}

	/**
	 * 根据疾病名称查询疾病
	 * @return
	 */
	public List<Disease> findByDiseaseName(String disease_name){
		return  this.diseaseMapper.findByDiseaseName(disease_name);
	}

	/**
	 * 保存导入疾病
	 *
	 * @param execlFile
	 * @param filePath
	 * @param logininfo
	 * @throws Exception
	 */
	public void saveImportDisease(MultipartFile execlFile, String filePath, LoginInfo logininfo) throws Exception {
		// 上传文件
		File fileFile = UtilAPI.saveFile(execlFile, filePath);
		Workbook rwb = Workbook.getWorkbook(fileFile);
		Sheet sheet = rwb.getSheet(0);
		// 获得有效行数
		int rowNum = sheet.getRows();
		// 获得有效列数 为防止内存溢出，设置Excel批量录入的有效列数为10
		int columnNum = sheet.getColumns();
		if (rowNum == 0 || columnNum == 0) {
			throw new BusinessException("导入的excel内容为空");
		}
		int startRow = 0;

		if (rowNum > startRow) {
			for (int i = startRow + 1; i < rowNum; i++) {
				Disease disease = new Disease();
				for (int j = 0; j < columnNum; j++) {
					Cell cellName = sheet.getCell(j, startRow);
					if (cellName != null) {
						String columnName = cellName.getContents();
						Cell cellValue = sheet.getCell(j, i);
						if (cellValue != null) {
							String value = UtilAPI.string2Trim(cellValue.getContents());
							if (!UtilAPI.isNull(columnName) && !UtilAPI.isNull(value)) {
								if ("疾病名称".equals(columnName)) {
									disease.setDisease_name(value);
								} else if ("科室名称".equals(columnName)) {
									disease.setDept_name(value);
								} else if ("疾病解释".equals(columnName)) {
									value = value.replace("  ", "\r\n");
									disease.setDisease_explain(value);
								} else if ("建议内容".equals(columnName)) {
									value = value.replace("  ", "\r\n");
									disease.setSuggest_content(value);
								} else if ("显示顺序".equals(columnName)) {
									disease.setDisp_order(UtilAPI.turnInt(value));
								}

							}
						}
					}
				}

				// 如果解析的数据行全部为空 则停止解析
				if (UtilAPI.isNull(disease.getDisease_name()) && UtilAPI.isNull(disease.getDept_name()) && UtilAPI.isNull(disease.getDept_name()) && UtilAPI.isNull(disease.getDisease_explain()) && UtilAPI.isNull(disease.getSuggest_content()) && UtilAPI.isNull(disease.getDisp_order())) {
					break;
				}

				// 开始导入疾病
				List<Disease> listDisease = this.diseaseMapper.findByDiseaseName(disease.getDisease_name());
				if (UtilAPI.isListNull(listDisease)) {

					List<Dept> listDept = this.deptImpl.findByDeptName(disease.getDept_name());
					if (!UtilAPI.isListNull(listDept)) {
						disease.setDept_id(listDept.get(0).getId());
						disease.setPinyin(PinyinAPI.getPinYinHeadChar(disease.getDisease_name()));
						disease.setWubi(WuBiAPI.getWuBiHeadChar(disease.getDisease_name()));
						disease.setCreate_date(new Date());
						disease.setCreate_user_id(logininfo.getUser().getId());
						this.insert(disease);
					}
				} else {
					// 修改
					Disease diseaseNew = listDisease.get(0);
					diseaseNew.setDisease_explain(disease.getDisease_explain());
					diseaseNew.setSuggest_content(disease.getSuggest_content());
					diseaseNew.setDisp_order(disease.getDisp_order());
					this.update(diseaseNew);
				}
			}

		}
		// 删除文件
		if (fileFile.exists()) {
			try {
				fileFile.deleteOnExit();
				fileFile.delete();
			} catch (Exception ex) {

			}
		}

	}W

}
