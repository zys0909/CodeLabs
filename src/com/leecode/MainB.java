package com.leecode;

import java.lang.ref.WeakReference;
import java.util.Date;

public class MainB {
    static WeakReference<String> w1;
    static WeakReference<String> w2;

    public static void main(String[] args) {
//        long time = new Date("Mon, 20 Jun 2022 06:08:44 GMT").getTime();
//        System.out.println(time);

        test();
        System.gc();
        System.out.println(w1.get() + "," + w2.get());
    }

    private static void test() {
        String s1 = new String("hello xxx");
        String s2 = "hello yyy";
        w1 = new WeakReference<>(s1);
        w2 = new WeakReference<>(s2);
        System.gc();
        System.out.println(w1.get() + "," + w2.get());
    }

}
