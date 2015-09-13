package com.cooliean.common.core.task;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

import android.os.Handler;
import com.cits.epark.mobile.ietree.utils.common.AppUtils;


/**
 * 串行异步池队列
 * 图片下载引擎
 * 这个每个任务不是挨着执行，不会等待上一个任务结束后才执行下一个的。
 *
 * @author fanj 2015-6-8
 */
public class FTaskLinkedPool extends FTask {
    private BlockingQueue<?> queue = null;
    private ExecutorService service = Executors.newFixedThreadPool(AppUtils.getNumCores() * 5);
    private Handler handler = new Handler();
    private FTaskCustomer<?> customer = null;

    @Override
    public <T> void execute(FTaskItem<T> item) {
        if (queue == null) {
            queue = new LinkedBlockingDeque<T>(Integer.MAX_VALUE);
        }
        if (customer == null) {
            customer = new FTaskCustomer(handler, queue, item);
            service.execute(customer);
        }
        service.execute(new FTaskProducer(queue, item));
    }

    @Override
    public <T> void executeSeries(FTaskItem<T>... items) {
        for (final FTaskItem item : items) {
            if (queue == null) {
                queue = new LinkedBlockingDeque<T>(Integer.MAX_VALUE);
            }
            if (customer == null) {
                customer = new FTaskCustomer(handler, queue, item);
                service.execute(customer);
            }
            service.execute(new FTaskProducer(queue, item));
        }
    }

    @Override
    public void shutDown() {
        super.shutDown();
    }
}
