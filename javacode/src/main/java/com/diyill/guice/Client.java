package com.diyill.guice;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

/**
 * @version 2017/5/22 下午2:04
 * @description 功能描述
 * @see
 * @since 1.0
 */

public class Client {
    public static void main(String[] args) {
        Injector in = Guice.createInjector(new MyModule());
        Hello hello = in.getInstance(Hello.class);
        hello.sayHello();

        Injector in2 = Guice.createInjector(new Module() {
            public void configure(Binder binder) {
//                针对静态属性的注入方式
//                binder.requestStaticInjection(HelloCaller.class);
            }
        });
        HelloCaller caller = in2.getInstance(HelloCaller.class);
        caller.sayHello();
    }
}
