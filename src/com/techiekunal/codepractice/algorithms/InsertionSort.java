package com.techiekunal.codepractice.algorithms;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {2,5,8,6,7,11,3,1,9};
        insertionSort(arr, arr.length);

        System.out.println("After sorting");
        System.out.print(Arrays.toString(arr));
    }

    public static void insertionSort(int[] arr, int n) {
        for(int i=1; i<n; i++) {
            int key = arr[i];
            int j = i-1;
            while(j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j-1;
            }
            arr[j+1] = key;
        }
    }

}
