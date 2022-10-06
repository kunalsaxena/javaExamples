package com.techiekunal.codepractice.algorithms;

import java.util.ArrayList;
import java.util.List;

public class NaiveStringMatching {

    public static void main(String[] args) {
        String text = "AABAACAADAABAABA";
        String pattern = "AABA";
        List<Integer> indexList = naivePatternMatching(text, pattern);

        if(indexList.isEmpty()) {
            System.out.println("Pattern didn’t match with text");
        } else {
            System.out.println("Pattern matched at indexes - " + indexList);
        }
    }


    private static List<Integer> naivePatternMatching(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        List<Integer> indexList = new ArrayList<>();

        for(int i = 0; i < n - m + 1; i++) {
            int j;
            int k = i;
            for(j = 0; j < m; j++, k++) {
                if(text.charAt(k) != pattern.charAt(j)) {
                    break;
                }
            }
            if(j == m) { // pattern has matched
                System.out.println("Pattern has matched at index - " + i);
                indexList.add(i);
            }
        }
        return indexList;
    }

}
