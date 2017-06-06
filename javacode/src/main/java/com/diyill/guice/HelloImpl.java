package com.diyill.guice;

import com.google.inject.Singleton;

/**
 * @version 2017/5/22 下午2:00
 * @description 功能描述
 * @see
 * @since 1.0
 */
@Singleton
public class HelloImpl implements Hello {
    public void sayHello() {

        System.out.println("HelloImpl say hello ");
    }
}
