package com.techiekunal.coding.interview.array;

import java.util.HashMap;

public class SubsetOfArray {

    public static void main(String[] args) {
        long[] a1 = {1,2,3,4,5,6,7,8};
        long[] a2 = {1,2,3,1};
        long n = 8;
        long m = 4;
        System.out.println(isSubset(a1, a2, n, m));
    }

    public static String isSubset( long a1[], long a2[], long n, long m) {

        HashMap<Long, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++) {
            Integer freq = map.get(a1[i]);
            if(freq == null) {
                map.put(a1[i], 1);
            } else {
                map.put(a1[i], freq + 1);
            }
        }

        for(int j = 0; j < m; j++) {
            Integer freq = map.get(a2[j]);
            if(freq == null || freq < 1) {
                return "No";
            } else {
                map.put(a2[j], freq - 1);
            }
        }
        return "Yes";
    }
}
