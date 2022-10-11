package com.techiekunal.coding.interview.array;

import java.util.Arrays;

public class ThreewayPartitionArray {

    public static void main(String[] args) {
        int[] arr = {1,2,3,3,4};
        threeWayPartition(arr, 1, 2);
        System.out.println("After Partition - " + Arrays.toString(arr));
    }

    public static void threeWayPartition(int array[], int a, int b)
    {
        // code here
        int i = 0;
        int n = array.length;
        int start = 0;
        int end = n-1;
        while(i <= end) {

            if(array[i] < a) {
                int swap = array[i];
                array[i] = array[start];
                array[start] = swap;
                i++;
                start++;

            }

            else if(array[i] > b) {
                int swap = array[i];
                array[i] = array[end];
                array[end] = swap;
                end--;
            } else {
                i++;
            }
        }
    }
}
