package com.response.standard.view;

/**
 * 外部访问成功的返回格式
 * @param <T>
 */
public class OutResponseSuccessView<T> {

    /**
     * 数据内容
     */
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
