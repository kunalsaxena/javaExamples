package com.techiekunal.coding.interview.string;

// Given a string, we have to find out all subsequences of it.
// A String is a subsequence of a given String, that is generated by deleting some character of a given string without changing its order.

public class AllSubsequences {

    public static void main(String[] a) {
        String str = "abc";
        printSubSequences(str, 0, "");
    }

    private static void printSubSequences(String str, int index, String curr){

        if(index != str.length()) {
            String temp = curr + str.charAt(index);
            System.out.println(temp);
            printSubSequences(str, index + 1, temp);
            printSubSequences(str, index + 1, curr);
        }
    }
}
