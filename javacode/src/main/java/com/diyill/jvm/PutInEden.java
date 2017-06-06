package com.diyill.jvm;

/**
 * @version 2017/5/18 上午10:13
 * @description 相同大小内存分配 JVM 参数-XX:+PrintGCDetails -Xmx20M -Xms20M 运行代码
 * @see
 * @since 1.0
 */

public class PutInEden {
    public static void main(String[] args) {
        byte[] b1,b2,b3,b4,b5;
        b1 = new byte[1024*1024]; //分配 1MB 堆空间，考察堆空间的使用情况
        b2 = new byte[1024*1024];
        b3 = new byte[1024*1024];
        b4 = new byte[1024*1024];
        b5 = new byte[1024*1024];
    }

}
