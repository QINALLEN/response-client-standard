package com.response.standard.view;

/**
 * 外部访问错误时的数据格式
 */
public class OuterResponseFailureView {

    /**
     * 错误消息编码
     */
    private Integer code;

    /**
     * 错误消息内容
     */
    private String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
