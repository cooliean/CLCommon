package com.cooliean.common.core.task;

import android.os.Handler;
import android.util.Log;

import java.util.concurrent.BlockingQueue;

/**
 * 消费者线程
 * @author fanj 2015-6-8
 *
 */
public class FTaskCustomer<T> extends Thread {

	private BlockingQueue<T> queue;
	private FTaskItem<T> task;
	private Handler mainHandler;
	private boolean isRunning = true;
	private Object lock = new Object();
	
	public FTaskCustomer(Handler mainHandler, BlockingQueue<T> queue, FTaskItem<T> task) {
		this.queue = queue;
		this.task = task;
		this.mainHandler = mainHandler;
	}
	
	@Override
	public void run() {
		try {
			while (isRunning) {
				final T t = queue.take();
				mainHandler.post(new Runnable() {
					
					@Override
					public void run() {
						task.update(t);
						synchronized (lock) {
							lock.notify();
						}
					}
				});
				synchronized (lock) {
					lock.wait();
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			Log.e("FTaskProducer.class====>", "消费数据失败");
		}
	}
	
}
