package com.techiekunal.coding.interview;

import java.util.Arrays;

/**
 * Median of two sorted arrays of same size
 */
public class MedianOfSortedArrays {

    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = {1, 12, 15, 26, 38};
        int[] arr2 = {2, 13, 17, 30, 45};

        merge(arr1, arr2, n);

        System.out.println("Arr1 " + Arrays.toString(arr1));
        System.out.println("Arr2 " + Arrays.toString(arr2));

        System.out.println("Median is - " + findMedian(arr1, arr2, n));

    }

    static void merge(int[] arr1, int[] arr2, int n) {
        // merge with 1 aux space
        // Algorithm - 1st element of 2nd array should be greater than all elements of arr1 :: if not then swap and run best case insertion sort
        for(int i = 0; i < n; i++) {

            if(arr1[i] > arr2[0]) {
                int temp = arr1[i];
                arr1[i] = arr2[0];
                arr2[0] = temp;
            }

            // insertion sort for arr2[0] - best case
            int key = arr2[0];
            int k = 1;
            while(arr2[k] < key && k < n) {
                arr2[k-1] = arr2[k];
                arr2[k] = key;
                k++;
                //arr2[k-1] = key;
            }
        }
    }

    private static int findMedian(int[] arr1, int[] arr2, int n) {
        int median = (arr1[n-1] + arr2[0])/2;
        // if we have 2 arrays of same size - total n will always be even
        return median;
    }

}
