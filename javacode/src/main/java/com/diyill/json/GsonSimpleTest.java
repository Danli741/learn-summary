package com.diyill.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.lang.reflect.Type;
import java.util.*;

/**
 * @version 2017/6/2 下午3:32
 * @description 功能描述
 * @see
 * @since 1.0
 */

public class GsonSimpleTest {
    public static void main(String[] args) {
        Student a = new Student("Alice", "Apple St", new Date(2000, 10, 1));
        Gson gson = new GsonBuilder()
                .serializeNulls()
                .setDateFormat("yyyy-MM-dd")
                .disableHtmlEscaping()
                .disableInnerClassSerialization()
                .excludeFieldsWithoutExposeAnnotation()
                .generateNonExecutableJson()
                .setPrettyPrinting()
                .create();
        System.out.println(gson.toJson(a));

    }

    //序列化数组
    @Test
    public void arrayTest() {
        int[] number = {1, 1, 2, 3, 5, 8, 13};
        String[] days = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};

        Gson gson = new Gson();
        String numbersJson = gson.toJson(number);
        String daysJson = gson.toJson(days);

        System.out.println("numberJson : " + numbersJson);
        System.out.println("daysJson : " + daysJson);

        int[] fibonacci = gson.fromJson(numbersJson,int[].class);
        System.out.println(Arrays.toString(fibonacci));

        String[] weekDays = gson.fromJson(daysJson,String[].class);

        System.out.println(Arrays.toString(weekDays));

        int[][] data = {{1, 2, 3}, {3, 4, 5}, {4, 5, 6}};
        String dataJson = gson.toJson(data);
        System.out.println(dataJson);

        int[][] dataMap = gson.fromJson(dataJson,int[][].class);
//        System.out.println(Arrays.toString(dataMap));
        for (int i = 0; i < dataMap.length; i++) {
            for (int j = 0; j < dataMap[i].length; j++) {
                System.out.print(dataMap[i][j] + " ");
            }
        }
        System.out.println();

     }

     @Test
     public void listTest() {
         List<String> names = new ArrayList<String>();
         names.add("Alice");
         names.add("Bob");
         names.add("Carol");
         names.add("Mallory");

         Gson gson = new Gson();
         String jsonNames = gson.toJson(names);
         System.out.println(jsonNames);

         Student a = new Student("Alice", "Apple St", new Date(2000, 10, 1));
         Student b = new Student("Bob", "Banana St", null);
         Student c = new Student("Carol", "Grape St", new Date(2000, 5, 21));
         Student d = new Student("Mallory", "Mango St", null);

         List<Student> students = new ArrayList<Student>();
         students.add(a);
         students.add(b);
         students.add(c);
         students.add(d);

         String jsonStudents = gson.toJson(students);
         System.out.println("jsonStudent : " + jsonStudents);

         Type type = new TypeToken<List<Student>>(){}.getType();
         List<Student> studentList = gson.fromJson(jsonStudents,type);

         for (Student student :
                 studentList) {
             System.out.println(student);
         }
         System.out.println("_______________________");
         String jsonString = "[{\"name\":\"Alice\",\"address\":\"Apple St\",\"date_of_birth\":\"Nov 1, 3900 12:00:00 AM\"},{\"name\":\"Bob\",\"address\":\"Banana St\"},{\"name\":\"Carol\",\"address\":\"Grape St\",\"date_of_birth\":\"Jun 21, 3900 12:00:00 AM\"},{\"name\":\"Mallory\",\"address\":\"Mango St\"}]";

         List<Student> studentList1 = gson.fromJson(jsonString,type);

         for (Student student :
                 studentList1) {
             System.out.println(student);
         }
     }

     @Test
     public void mapTest() {
         Map<String, String> colours = new HashMap<String, String>();
         colours.put("BLACK", "#000000");
         colours.put("RED", "#FF0000");
         colours.put("GREEN", "#008000");
         colours.put("BLUE", "#0000FF");
         colours.put("YELLOW", "#FFFF00");
         colours.put("WHITE", "#FFFFFF");

         Gson gson = new Gson();
         String colorsJson = gson.toJson(colours);
         System.out.println(colorsJson);


         Type type = new TypeToken<Map<String,String>>(){}.getType();
         Map<String,String> colorsMap = gson.fromJson(colorsJson,type);
         for (String key :
                 colorsMap.keySet()) {
             System.out.println("map, key : " + key + " value : " + colorsMap.get(key));
         }
     }


}
