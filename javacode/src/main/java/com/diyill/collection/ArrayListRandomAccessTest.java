package com.diyill.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liuwei
 * @version 17/5/18 上午12:53
 * @modified
 * @description ArrayList几种遍历方式性能比较
 * 遍历ArrayList时，使用随机访问(即，通过索引序号访问)效率最高，而使用迭代器的效率最低！
 * @see
 * @since 1.0
 */
public class ArrayListRandomAccessTest {

    public static void main(String[] args) {
        List list = new ArrayList();
        for (int i = 0; i < 100000; i++) {
            list.add(i);
        }
        iteratorThroughRandomAccess(list);
        iteratorThroughIterator(list);
        iteratorThroughFor2(list);
    }

    public static void iteratorThroughRandomAccess(List list){
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("iteratorThroughRandomAccess 用时：" +  (endTime - startTime) + " ms");
    }

    public static void iteratorThroughIterator(List list){
        long startTime = System.currentTimeMillis();
        for (Iterator iter = list.iterator(); iter.hasNext();){
            iter.next();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("iteratorThroughIterator 用时：" +  (endTime - startTime) + " ms");
    }

    public static void iteratorThroughFor2(List list){
        long startTime = System.currentTimeMillis();
        for (Object obj : list){

        }
        long endTime = System.currentTimeMillis();
        System.out.println("iteratorThroughFor2 用时：" +  (endTime - startTime) + " ms");
    }
}

