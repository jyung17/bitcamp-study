package main.java.com.eomcs.lang.ex04.assignment;

import java.util.Scanner;
 
public class Test02_c {
    public static void main(String[] args) {
        String[] name = new String[5];
        int[] kSub = new int[5];
        int[] eSub = new int[5];
        int[] mSub = new int[5];
        int[] sum = new int[5];
        float[] avg = new float[5];

        Scanner scanner = new Scanner(System.in);

        for(int i=0; i<5; i++) { 
            System.out.print("입력? ");
            name[i] = scanner.next();
            kSub[i] = scanner.nextInt();
            eSub[i] = scanner.nextInt();
            mSub[i] = scanner.nextInt();
            sum[i] = kSub[i] + eSub[i] + mSub[i];
            avg[i] = sum[i] / 3; 
        }

        System.out.println("-----------");
        for(int i=0; i<5; i++) { 
            System.out.printf("%s %d %d %d %d %.1f\n", name[i], kSub[i], eSub[i], mSub[i], sum[i], avg[0]);
        }
    }
}
