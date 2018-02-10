/**
 * 
 */
package com.exp.zsq.juc.executor.forkjoin.FjApp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lhjc.tj.dict.Dict;
import com.lhjc.tj.dict.Sex;
import com.lhjc.tj.service.disease.pojo.Disease;

/**
 * @author wwq
 *
 */
public class DiseaseTask{
	@Autowired
	private DiseaseImpl diseaseImpl;

	private List<Disease> diseList;

	private int size;

	private int start;

	private int end;

	public DiseaseTask(List<Disease> diseList, int start, int end){
		this.diseList=diseList;
		this.start=start;
		this.end=end;
		this.size=end - start;
	}

	public List<Map<String, Object>> reverseSearch(Integer sex, String... summList){
		List<Map<String, Object>> diseMapList=new ArrayList<Map<String, Object>>();
		for(String summ : summList){
			for(int i=start; i<=end;i++){
				Disease dise = diseList.get(i);
				//标题检索
				if(summ.indexOf(dise.getDisease_name())!=-1){
					if((","+dise.getSex()+",").indexOf(","+sex+",")==-1){
						continue;
					}
					Map<String, Object> diseMap=new HashMap<String, Object>();
					diseMap.put("id", dise.getId());
					diseMap.put("disease_name", dise.getDisease_name());
					diseMap.put("sex", Sex.get(dise.getSex()));
					diseMapList.add(diseMap);
					continue;
				}
				//关键字拆分检索
				if(dise.getMap_keys()!=null){
					String[] keys=dise.getMap_keys().split(",");
					for(String key : keys){
						if(summ.indexOf(key)!=-1){
							if((","+dise.getSex()+",").indexOf(","+sex+",")==-1){
								continue;
							}
							Map<String, Object> diseMap=new HashMap<String, Object>();
							diseMap.put("id", dise.getId());
							diseMap.put("disease_name", dise.getDisease_name());
							diseMap.put("sex", Sex.get(dise.getSex()));
							diseMapList.add(diseMap);
							break;
						}
					}
				}

			}
		}
		return diseMapList;
	}
	public DiseaseTask subTask(int subStart,int subEnd){
		return new DiseaseTask(diseList ,start+subStart, start+subEnd);
	}
	/**
	 * @return 返回size
	 */
	public int getSize() {
		return size;
	}
}
