package com.techiekunal.coding.interview.string;

import java.util.Scanner;

public class FindDuplicates {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        printDuplicates(s);
    }

    private static void printDuplicates(String s) {

        int[] arr = new int[256];
        for(int i=0; i < s.length(); i++) {
            int index = (int) s.charAt(i);
            if(arr[index] == 0) {
                arr[index] = 1;
            } else {
                arr[index] += 1;
            }
        }

        for(int i=0; i < s.length(); i++) {
            int index = (int) s.charAt(i);
            if(arr[index] > 1) {
                System.out.println(s.charAt(i));
            }
        }

    }

}
