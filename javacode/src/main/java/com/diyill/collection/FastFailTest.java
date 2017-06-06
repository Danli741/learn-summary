package com.diyill.collection;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @version 2017/6/5 下午12:21
 * @description 功能描述
 * @see
 * @since 1.0
 */

public class FastFailTest {
//    private static List<String> list = new ArrayList<String>();
    private static List<String> list = new CopyOnWriteArrayList<String>();

    public static void main(String[] args) {
        new ThreadOne().start();
        new ThreadTwo().start();
    }

    private static void printAll() {
        System.out.println("");

        String value = null;
        Iterator iter = list.iterator();
        while(iter.hasNext()) {
            value = (String)iter.next();
            System.out.print(value+", ");
        }
    }

    private static class ThreadOne extends Thread {
        public void run() {
            int i = 0;
            while (i<6) {
                list.add(String.valueOf(i));
                printAll();
                i++;
            }
        }
    }

    private static class ThreadTwo extends Thread {
        public void run() {
            int i = 10;
            while (i<16) {
                list.add(String.valueOf(i));
                printAll();
                i++;
            }
        }
    }

}
