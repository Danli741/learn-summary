package com.diyill.guice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author liuxiaobin@58ganji.com
 * @version 2017/5/22 下午2:36
 * @description 功能描述
 * @see
 * @since 1.0
 */

public class MyInterceptor implements MethodInterceptor {
    public Object invoke(MethodInvocation invocation) throws Throwable {
        doBefore();
        Object ret = invocation.proceed();
        doAfter();
        return  ret;
    }

    public void doBefore(){

    }

    public void doAfter() {

    }
}
