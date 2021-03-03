package com.response.standard.advice;

import com.response.standard.view.InnerResponseFailureView;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * 内部消息统一格式处理
 */
@ControllerAdvice
public class InnerResponseBodyAdvice extends AbstractResponseBodyAdvice {

    /**
     * 判断是否支持统一格式处理
     * @param methodParameter
     * @param aClass
     * @return
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        if (!super.supports(methodParameter,aClass)){
            return false;
        }
        IgnoreResponseBodyAdvice ignoreResponseBodyAdvice = methodParameter.getMethodAnnotation(IgnoreResponseBodyAdvice.class);
        if (ignoreResponseBodyAdvice !=null && ignoreResponseBodyAdvice.ignoreInner()){
            return false;
        }
        return !isNotInner();
    }

    /**
     * support为true时，返回数据时才执行该方法
     *
     * @param o
     * @param methodParameter
     * @param mediaType
     * @param aClass
     * @param serverHttpRequest
     * @param serverHttpResponse
     * @return
     */
    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (o instanceof InnerResponseFailureView) {
            return o;
        }
        int status = ((ServletServerHttpResponse) serverHttpResponse).getServletResponse().getStatus();
        if (status == HttpStatus.OK.value()) {
            return o;
        } else {
            return InnerResponseFailureView.message((String) o);
        }
    }
}
