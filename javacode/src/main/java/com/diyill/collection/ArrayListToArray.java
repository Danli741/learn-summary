package com.diyill.collection;

import java.util.ArrayList;

/**
 * @version 2017/6/5 上午10:51
 * @description 功能描述
 * @see
 * @since 1.0
 */

public class ArrayListToArray {
    public static Integer[] vectoryToArray(ArrayList<Integer> v) {
        Integer[] integers = new Integer[v.size()];
        v.toArray(integers);
        return integers;
    }

    public static Integer[] vectoryToArray2(ArrayList<Integer> v) {
        return v.toArray(new Integer[v.size()]);
    }

}
