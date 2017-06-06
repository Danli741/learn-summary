package com.diyill.guice;

import com.google.inject.ImplementedBy;

/**
 * @version 2017/5/22 下午1:59
 * @description 功能描述
 * @see
 * @since 1.0
 */
@ImplementedBy(HelloImpl.class)
public interface Hello {
    void sayHello();
}
