package com.techiekunal.coding.interview.stringques;

import org.springframework.util.StopWatch;

import java.util.ArrayList;

public class StringRotation {

    public static void main(String[] args) {

        String str = "ABCD";
        String pattern = "CDAB";

        StopWatch sw = new StopWatch("Elapsed Time Counter");
        sw.start("Rotation");

//        System.out.println(checkStringRotation(str, pattern) == true ? "Rotation Found" : "Rotation not found");

        System.out.println(kmpMatch(str, pattern) == true ? "Rotation Found" : "Rotation not found");

        sw.stop();
        System.out.println(sw.prettyPrint());
    }

    private static boolean isStringRotated(String str, String pattern) {
        String tempStr = str + str;
        if(tempStr.indexOf(pattern)!= -1) {
            return true;
        }
        return false;
    }

    // ========================= Approach #2 ===========================
    private static boolean checkStringRotation(String str1, String str2) {
        return naivePatternMatching(str1 + str1, str2);
    }

    private static boolean naivePatternMatching(String str, String pattern) {
        ArrayList<Integer> list = new ArrayList<>();
        int n = str.length();
        int m = pattern.length();

        for(int i = 0; i < n - m; i++) {
            if(str.charAt(i) == pattern.charAt(0)) {
                list.add(i);
            }
        }

        for(Integer i : list) {
            int j = 0;
            while(j < m) {
                if(str.charAt(i++) != pattern.charAt(j++)) {
                    break;
                }
            }
            if(j == m) {
                return true;
            }
        }
        return false;
    }

    // ================================== KMP Matcher approach ====================================

    private static int[] buildLPS(String pattern) {

        int m = pattern.length();
        int[] lps = new int[m];
        int count = 0;
        int i = 1;
        while(i < m) {
            if(pattern.charAt(i) == pattern.charAt(count)) {
                count++;
                lps[i] = count;
                i++;
            } else {
                // do same like search step
                if(count != 0) { // AAAACAAAA
                    count = lps[count -1];
                } else { // where count = 0
                    i++;
                }
            }
        }
        return lps;
    }

    private static boolean kmpMatch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        int i = 0; // for text
        int j = 0; // for pattern
        int[] lps = buildLPS(pattern);

        while(i < n && j < m) {
            if(text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                if(j != 0) {
                    j = lps[j-1];
                } else { // where j = 0
                    i++;
                }
            }
        }
        if(j == m) {
            return true;
        }
        return false;
    }

}
