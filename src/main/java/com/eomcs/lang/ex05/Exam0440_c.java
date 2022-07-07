package com.eomcs.lang.ex05;

public class Exam0440_c {
    public static void main(String[] args) {
        int i = 0x27a130ff;
        int a, b, c, d;

        System.out.println(i);
        System.out.println(Integer.toHexString(i));

        a = i >> 24;
        System.out.println(Integer.toHexString(a));
    }
}
