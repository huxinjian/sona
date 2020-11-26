package com.jiuye.sona.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @Author: xinjian.hu
 * @Date: 2020/11/12 13:29
 * @Email: huxinjian@jiuyescm.com
 */
public class MyFunctionalInterfaceTest {



    public static void main(String[] args) {
        show("hello wrold", msg -> System.out.println(msg));

//       Consumer cnsumer = ("1234") -> {
//            String reverse = new StringBuffer("1234").reverse().toString();
//            System.out.printf(reverse);
//        };

       List<String> list = new ArrayList<>();
       list.forEach(str -> System.out.println(str));

    }

    public static void show(String message, MyFunctionalInterface myFunctionalInterface) {
        myFunctionalInterface.method(message);
    }
}
