package com.techiekunal.codepractice.algorithms;

import java.util.ArrayList;
import java.util.List;

public class RabinKarpStringMatching {

    private static int base = 31;
    private static int mod = Integer.MAX_VALUE; // very long prime but fitting

    public static void main(String[] args) {
        String text = "AABAACAADAABAABA";
        String pattern = "AABA";
        List<Integer> indexList = rabinKarpMatching(text, pattern);

        if(indexList.isEmpty()) {
            System.out.println("Pattern didn’t match with text");
        } else {
            System.out.println("Pattern matched at indexes - " + indexList);
        }
    }

    // example - 500 + 20 + 3 = 523 | (523 - 500) * 10 + 8
    private static int computeHash(String str, int start, int n) {
        int hashVal = 0;

        for(int i = start; i < n; i++) {
            hashVal = ( hashVal + str.charAt(i) * (int) Math.pow(base, n - 1 - i) ) % mod;
        }
        return hashVal;
    }

    private static int rollingHash(char prev, char next, int prevHash, int n) {

        int newHash = (prevHash - prev * (int) Math.pow(base, n-1)) % mod; // removing starting char effect
        newHash  = (newHash * base + next) % mod; // add new char effect

        if(newHash < 0) {
            newHash += base;
        }
        return newHash;
    }

    private static List<Integer> rabinKarpMatching(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        List<Integer> matchIndexList = new ArrayList<>();

        // calc hash of window
        int patternHash = computeHash(pattern, 0, m);
        int textWindowHash = computeHash(text, 0, m);

        // iterate over text
        for(int i=0; i<n-m+1; i++) {

            if(patternHash == textWindowHash) {
                int k = i;
                int j;
                for(j=0; j<m; j++, k++) {
                    if(pattern.charAt(j) != text.charAt(k)) {
                        break;
                    }
                }
                if(j==m) {
                    matchIndexList.add(i);
                }
            }

            // start sliding window, compute rolling Hash for next sequence
            if(i < n - m) {
                textWindowHash = rollingHash(text.charAt(i), text.charAt(i+m), textWindowHash, m);
            }
        }
        return matchIndexList;
    }

}
