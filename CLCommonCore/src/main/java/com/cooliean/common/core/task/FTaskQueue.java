package com.cooliean.common.core.task;


import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import android.os.Handler;

/**
 * 同步线程队列
 *
 * @author fanj
 * @date：2015-6-3
 */
public class FTaskQueue extends FTask {
    private ExecutorService service = Executors.newSingleThreadExecutor();
    private Handler handler = new Handler();

    /**
     * 开始一个执行任务. 线程间无关联执行
     *
     * @param item 任务执行单位
     */
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
     * 开始执行多个串联任务. 线程间有关联执行 在更新完ui后才执行下一个队列
     *
     * @param items 任务执行单位
     */
    public <T> void executeSeries(FTaskItem<T>... items) {
        for (final FTaskItem item : items) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    item.setData(item.getObject());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            item.update(item.getData());
                            synchronized (service) {
                                service.notify();
                            }
                        }
                    });
                    try {
                        synchronized (service) {
                            service.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    //	@date：2015-08-16 add by cooliean
    public <T> void executeSeries(List<FTaskItem<T>> items) {
        for (final FTaskItem item : items) {
            System.out.println("executeSeries");
            service.execute(new Runnable() {
                @Override
                public void run() {
                    item.setData(item.getObject());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            item.update(item.getData());
                            synchronized (service) {
                                service.notify();
                            }
                        }
                    });
                    try {
                        synchronized (service) {
                            service.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
