package com.cooliean.common.core.task;

/**
 * 普通任务执行单位
 *
 * @param <T>
 * @author fanj
 * @date：2015-6-3
 */
public abstract class FTaskItem<T> {
    private T data;
    //	@date：2015-08-16 add by cooliean
    private boolean lastItem = false;

    /**
     * Gets the object.
     *
     * @return 返回的结果对象
     */
    public abstract T getObject();

    /**
     * 描述：执行开始后调用.
     *
     * @param obj the obj
     */
    public abstract void update(T obj);

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isLastItem() {
        return lastItem;
    }

    public void setLastItem(boolean lastItem) {
        this.lastItem = lastItem;
    }
}

