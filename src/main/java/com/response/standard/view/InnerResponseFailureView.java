package com.response.standard.view;

/**
 * 内部访问错误时的数据格式
 */
public class InnerResponseFailureView {

    /**
     * 错误消息
     */
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private InnerResponseFailureView(String message) {
        this.message = message;
    }

    public static InnerResponseFailureView message(String message){
        return new InnerResponseFailureView(message);
    }
}
