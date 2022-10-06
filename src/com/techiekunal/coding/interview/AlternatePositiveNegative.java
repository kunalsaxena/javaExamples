package com.techiekunal.coding.interview;

import java.util.Arrays;

public class AlternatePositiveNegative {

    public static void main(String[] args) {
        int n = 10;
        int[] arr = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};

        rearrange(arr, n);
        // 5 -5 2 -2 4 -8 7 1 8 0
        System.out.println(Arrays.toString(arr));
    }

    static void rearrange(int arr[], int n) {

        // code here
        // using two pointers :: i for positive index pos and j for -ve indexes
        // even index - positive numbers
        // odd index - negative numbers

        // find count of negative numbers
        int negCount = 0;
        for(int k = 0; k < n; k++) {
            if(arr[k] < 0) {
                negCount++;
            }
        }

        int posCount = n - negCount;

        int min = posCount > negCount ? negCount : posCount;

        int[] pos = new int[posCount];
        int[] neg = new int[negCount];
        int i = 0;
        int j = 0;

        for(int k = 0; k < n; k++) {
            if(arr[k] < 0) {
                neg[j] = arr[k];
                j++;
            } else {
                pos[i] = arr[k];
                i++;
            }
        }

        i = 0;
        int m = 0;
        while(m < min) {
            arr[i] = pos[m];
            i+=2;
            m++;
        }

        j = 1;
        int r = 0;
        while(r < min) {
            arr[j] = neg[r];
            j+=2;
            r++;
        }

        int k = min * 2;
        while(m < posCount && m < n) {
            arr[k] = pos[m];
            k++;
            m++;
        }

        while(r < negCount && r < n) {
            arr[k] = neg[r];
            k++;
            r++;
        }
    }
}
