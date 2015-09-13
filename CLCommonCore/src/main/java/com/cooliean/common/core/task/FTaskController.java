package com.cooliean.common.core.task;
/**
 * 多线程控制器
 * 
 * @author fanj
 * @date：2015-6-3
 */
public class FTaskController {
	private FTask task = null;

	public FTaskController(FTask task) {
		this.task = task;
	}

	public static FTaskController create(FTask task) {
		return new FTaskController(task);
	}

	public void execute(final FTaskItem item) {
		task.execute(item);
	};

	public void executeSeries(final FTaskItem... items) {
		task.executeSeries(items);
	};

	public void shutDown() {
		task.shutDown();
	};
}
