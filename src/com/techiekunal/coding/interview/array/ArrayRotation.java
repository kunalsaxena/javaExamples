package com.techiekunal.coding.interview.array;

/**
 * Clock-wise rotate array by given k
 */
public class ArrayRotation {

    public static void main(String[] args) {

        int[] arr = {9, 8, 7, 6, 4, 2, 1, 3};
        int k = 3; // rotate by
        int n = 8;
        rotate(arr, n, k);
        for (int i=0; i<n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void rotate(int[] arr, int n, int k) {
        int[] aux = new int[n];

        // copy from n-k to n
        int countAux = 0;
        for(int i = n-k; i < n; i++) {
            aux[countAux] = arr[i];
            countAux++;
        }

        // copy from start to n-k-1
        for(int i = 0; i < n-k; i++) {
            aux[countAux] = arr[i];
            countAux++;
        }

        // copy from aux to real array
        for(int i = 0; i < n; i++) {
            arr[i] = aux[i];
        }
    }

}
