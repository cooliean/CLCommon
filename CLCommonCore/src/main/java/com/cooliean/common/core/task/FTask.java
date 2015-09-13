package com.cooliean.common.core.task;

import java.util.concurrent.ExecutorService;

import android.util.Log;

/**
 * 线程队列
 * 
 * @author fanj
 * @date：2015-6-3
 */
public abstract class FTask {
	private ExecutorService service;
	public abstract <T> void execute(final FTaskItem<T> item);

	public abstract <T> void executeSeries(final FTaskItem<T>... items);

	public void shutDown(){
		try{
			if(service != null) {
				service.shutdownNow();
			}
		}catch(Exception e){
			Log.e("FTask.class===>", "ExecutorService异常关闭！");
		}
		
	};
}
