package com.response.standard.advice;

import java.lang.annotation.*;

/**
 * 自定义是否忽略标准数据格式
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(value = {ElementType.METHOD})
public @interface IgnoreResponseBodyAdvice {

    /**
     * 忽略外部统一格式输出
     * true: 忽略，false：不忽略
     * @return
     */
    boolean ignoreOuter() default false;

    /**
     * 忽略内部统一格式输出
     * true: 忽略，false：不忽略
     * @return
     */
    boolean ignoreInner() default false;
}
