package com.diyill.guice;

import com.google.inject.Inject;

/**
 * @author liuxiaobin@58ganji.com
 * @version 2017/5/22 下午2:09
 * @description 功能描述
 * @see
 * @since 1.0
 */

public class HelloCaller {

    //属性注入
//    @Inject
//    @Named("")  @Named注解来完成一个接口（父类）绑定多个实现类（子类）的方式
    private Hello hello;

    //构造方法注入
//    @Inject
    public HelloCaller(Hello hello) {
        this.hello = hello;
    }

    public Hello getHello() {
        return hello;
    }

    @Inject
    public void setHello(Hello hello) {
        this.hello = hello;
    }

    public void sayHello() {
        hello.sayHello();
    }
}
