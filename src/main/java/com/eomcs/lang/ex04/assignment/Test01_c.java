package main.java.com.eomcs.lang.ex04.assignment;

import java.util.Scanner;

public class Test01_c {
    public static void main(String[] args) {
        System.out.printf("이름? ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        System.out.printf("국어? ");
        int kSub = scanner.nextInt();

        System.out.printf("영어? ");
        int eSub = scanner.nextInt();

        System.out.printf("수학? ");
        int mSub = scanner.nextInt();

        int total = kSub + eSub + mSub;
        double ave = total / 3.0f;

        System.out.println(name + " " + kSub + " " + eSub + " " + mSub + " " + total + " " + ave);
    }
}
