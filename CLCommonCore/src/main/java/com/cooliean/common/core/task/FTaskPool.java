package com.cooliean.common.core.task;

import android.os.Handler;
import com.cits.epark.mobile.ietree.utils.common.AppUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 异步线程队列
 * 
 * @author fanj
 * @date：2015-6-3
 */
public class FTaskPool extends FTask {
	private ExecutorService service = Executors.newFixedThreadPool(AppUtils.getNumCores()*5);
	private Handler handler = new Handler();

	/**
	 * 添加一个执行任务
	 * 
	 * @param item
	 *            任务执行单位
	 */
	@Override
	public <T> void execute(final FTaskItem<T> item) {
		service.execute(new Runnable() {

			@Override
			public void run() {
				item.setData(item.getObject());
				handler.post(new Runnable() {
					@Override
					public void run() {
						item.update(item.getData());
					}
				});
			}
		});
	}

	/**
	 * 添加多个任务
	 * 
	 * @param items
	 *            任务执行单位
	 */
	@Override
	public <T> void executeSeries(FTaskItem<T>... items)  {
		for (final FTaskItem item : items) {
			service.execute(new Runnable() {
				@Override
				public void run() {
					item.setData(item.getObject());
					handler.post(new Runnable() {
						@Override
						public void run() {
							item.update(item.getData());
						}
					});
				}
			});
		}
	}
}
