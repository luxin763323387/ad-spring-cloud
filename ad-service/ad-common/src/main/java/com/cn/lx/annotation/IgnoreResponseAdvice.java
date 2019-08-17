package com.cn.lx.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * 某些类和方法不进行拦截
 * @author StevenLu
 * @date 2019/7/20
 */
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface IgnoreResponseAdvice {
}
