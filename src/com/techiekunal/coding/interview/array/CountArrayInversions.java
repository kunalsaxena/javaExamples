package com.techiekunal.coding.interview.array;

import javax.swing.plaf.IconUIResource;
import java.util.Arrays;

public class CountArrayInversions {

    static int count = 0;

    public static void main(String[] args) {

        int[] arr = {174,165,142,212,254,369,48,145,163,258,38,360,224,242,30,279,317,36,191,343,289,107,41,443,265,149,447,306,391,230,371,351,7,102};

        System.out.println("Before sorting - " + Arrays.toString(arr));
        sort(arr, 0, arr.length - 1);
        System.out.println("After sorting - " + Arrays.toString(arr));

        System.out.println("Count is - " + count);

    }

    private static void sort(int[] arr, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            sort(arr, p, q);      // left
            sort(arr, q + 1, r);      // right
            merge(arr, p, q, r);  // merge
        }
    }

    private static void merge(int[] arr, int p, int q, int r) {

        // divide this into two subarrays : pivot - q
        int n1 = q - p + 1;
        int n2 = r - q;

        int[] leftArr = Arrays.copyOfRange(arr, p, q + 1); // to is exclusive - can lie outside array
        int[] rightArr = Arrays.copyOfRange(arr, q + 1, r + 1);

        // compare
        int k = p;
        int i = 0, j = 0;
        // run till both piles have cards :: put smaller card in final pile
        while (i < n1 && j < n2) {

            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
                count += (q + 1) - (p + i);
            }
        }

        //copy remaining elements from first pile if any
        while (i < n1) {
            arr[k++] = leftArr[i++];
        }

        //copy remaining elements from second pile if any
        while (j < n2) {
            arr[k++] = rightArr[j++];
        }
    }
}
