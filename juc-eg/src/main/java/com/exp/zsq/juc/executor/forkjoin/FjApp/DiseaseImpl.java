package com.exp.zsq.juc.executor.forkjoin.FjApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;


public class DiseaseImpl {

	/**
	 *
	 * @return
	 */
	public List<Map<String, Object>> reverseSearch(Integer sex, String... searchContent) {
		List<KeyWordBean> diseCacheList = new ArrayList<>();
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
				String diseName1 = (String) listMap.get(j).get("disease_name");
				String diseName2 = (String) listMap.get(i).get("disease_name");
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


}
