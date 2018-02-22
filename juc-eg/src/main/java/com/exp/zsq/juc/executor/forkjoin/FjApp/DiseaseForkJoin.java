/**
 * 
 */
package com.exp.zsq.juc.executor.forkjoin.FjApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;


/**
 * @author wwq
 *
 */
public class DiseaseForkJoin extends RecursiveAction {
	private DiseaseTask task;

	private int threshold;

	private String [] searchContent;

	private List<Map<String, Object>> diseMapList = new ArrayList<Map<String, Object>>();

	private Integer sex;

	public DiseaseForkJoin(DiseaseTask task, int threshold , String [] searchContent, Integer sex){
		this.task=task;
		this.searchContent=searchContent;
		this.threshold=threshold;
		this.sex=sex;
	}
	@Override
	protected void compute() {
		if(task.getSize() < threshold){
			diseMapList.addAll(task.reverseSearch(this.sex, searchContent));
		}else{
			//分解子任务
			int midPoint = task.getSize()/2;
			DiseaseForkJoin subTask1=new DiseaseForkJoin(task.subTask(0, midPoint),threshold, searchContent, this.sex);
			DiseaseForkJoin subTask2=new DiseaseForkJoin(task.subTask(midPoint+1, task.getSize()),threshold, searchContent, this.sex);
			invokeAll(subTask1, subTask2);
			diseMapList.addAll(subTask1.getDiseMapList());
			diseMapList.addAll(subTask2.getDiseMapList());
		}
	}

	public static void main(String args[]){
		List<KeyWordBean> diseList=new ArrayList();
		for(int i=0;i<136;i++){
			KeyWordBean dise=new KeyWordBean();
			dise.setDisease_name("测试"+i+"测试"+i+"测试"+i);
			dise.setSex("0,1");
			dise.setMap_keys("wwq"+i+",wwq"+i+",wwq"+i);
			diseList.add(dise);
		}
		DiseaseTask dtask=new DiseaseTask(diseList, 0, diseList.size()-1);
		String[] searchContent={"wwq89", "wwq2", "wwq135"};
		//并行任务数量
		int threshold=36;
		//线程数
		int nThreads=10;
		DiseaseForkJoin dfj=new DiseaseForkJoin(dtask, threshold, searchContent, 1);
		ForkJoinPool fjPool = new ForkJoinPool(nThreads);
		fjPool.invoke(dfj);

		List<Map<String, Object>> diseMapList=dfj.getDiseMapList();
		System.out.println("共计："+diseMapList.size());
		System.out.println("================================================");
		for(int i=0;i<diseMapList.size();i++){
			System.out.println(diseMapList.get(i).get("disease_name"));
		}
	}
	/**
	 * @return 返回diseMapList
	 */
	public List<Map<String, Object>> getDiseMapList() {
		return diseMapList;
	}
}
