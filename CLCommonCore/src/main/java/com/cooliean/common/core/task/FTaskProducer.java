package com.cooliean.common.core.task;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import android.util.Log;

/**
 * 生产者线程
 * @author fanj 2015-6-8
 *
 * @param <T>
 */
public class FTaskProducer<T> extends Thread {

	private BlockingQueue<T> queue;
	private FTaskItem<T> task;
	
	public FTaskProducer(BlockingQueue<T> queue, FTaskItem<T> task) {
		this.queue = queue;
		this.task = task;
	}

	@Override
	public void run() {
		T t = task.getObject();
		try {
			if (t != null && !queue.offer(t, 2, TimeUnit.SECONDS)) {
//				Log.e("FTaskProducer.class====>", t.toString());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
//			Log.e("FTaskProducer.class====>", "生产数据失败");
		}
	}

}
