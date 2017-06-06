package com.diyill.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Since;
import com.google.gson.annotations.Until;

/**
 * @version 2017/6/3 上午10:55
 * @description 功能描述
 * @see
 * @since 1.0
 */

class Simples{
    @Since(4)
    public String since;

    @Until(5)
    public String util;


    public static void main(String[] args) {
        Simples  simples = new Simples();
        simples.since = "since";
        simples.util = "util";

        Gson gson = new GsonBuilder().setVersion(5).create();
        System.out.println(gson.toJson(simples));
    }
}



