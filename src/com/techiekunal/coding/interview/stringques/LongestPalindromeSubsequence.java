package com.techiekunal.coding.interview.stringques;

public class LongestPalindromeSubsequence {

    public static int longestPalindromeSubseq(String s) {

        int n = s.length();
        int[][] dp = new int[n][n];
        int length = 1;
        int maxLength = 1;

        // initialze
        for(int i=0; i<s.length(); i++) {
            int j = i;
            dp[i][j] = 1;
        }

        while(length <= n) {
            int j;
            for(int i=0; i < n-1 && i + length < n; i++) {
                j = i + length;
                if(s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Integer.max(dp[i][j-1], dp[i+1][j]);
                }
                maxLength = Integer.max(maxLength, dp[i][j]);
            }
            length++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("bbbab"));
    }

}
