package com.response.standard.advice;

import org.springframework.core.MethodParameter;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

public abstract class AbstractResponseBodyAdvice implements ResponseBodyAdvice {


    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String uri =  request.getRequestURI();
        if (uri.contains("/swagger-resources") || uri.contains("/v3/api-docs") || uri.contains("/v2/api-docs")){
            return false;
        }
        return true;
    }

    /**
     * 判断请求来源于外部还是服务之间的内部调用
     * @return  true: 外部服务，false: 内部服务
     */
    protected boolean isNotInner(){
        return isNotInner(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
    }

    /**
     * 判断请求来源于外部还是服务之间的内部调用
     * @param request
     * @return  true: 外部服务，false: 内部服务
     */
    protected Boolean isNotInner(HttpServletRequest request){
        String inner = request.getHeader("inner");
        return StringUtils.isEmpty(inner) || !"true".equalsIgnoreCase(inner);
    }
}
