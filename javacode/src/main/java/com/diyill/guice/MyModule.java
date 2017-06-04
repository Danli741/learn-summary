package com.diyill.guice;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.matcher.Matchers;
import com.google.inject.name.Names;

/**
 * @author liuxiaobin@58ganji.com
 * @version 2017/5/22 下午2:00
 * @description 功能描述
 * @see
 * @since 1.0
 */

public class MyModule implements Module {
    public void configure(Binder binder) {
//        binder.bind(Hello.class).to(HelloImpl.class).in(Singleton.class);

        binder.bind(Hello.class).annotatedWith(Names.named("HelloImpl1")).to(HelloImpl.class);

        binder.bindConstant().annotatedWith(Names.named("name")).to("namesss");

        binder.bindInterceptor(Matchers.any(),Matchers.annotatedWith(Names.named("log")),new MyInterceptor());
    }
}
