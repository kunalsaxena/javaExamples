package com.techiekunal.coding.interview.array;

import java.util.Arrays;

public class MedianofSortedDiffArray {

    public static void main(String[] args) {
        int[] nums1 = {3};
        int[] nums2 = {-2,-1};
        int n1 = nums1.length;
        int n2 = nums2.length;
        merge(nums1, nums2, n1, n2);

        System.out.println("Arr1 - " + Arrays.toString(nums1));
        System.out.println("Arr2 - " + Arrays.toString(nums2));
        System.out.println("Median is - " + findMedian(nums1, nums2, n1, n2));
    }

    private static void merge(int[] nums1, int[] nums2, int n1, int n2) {

        if(n1 > 0 && n2 > 0) {

            for (int i = 0; i < n1; i++) {

                if (nums1[i] > nums2[0]) {
                    int temp = nums1[i];
                    nums1[i] = nums2[0];
                    nums2[0] = temp;
                }

                int key = nums2[0];
                if (n2 > 1) {
                    int k = 1;
                    while ( k < n2 && nums2[k] < key ) {
                        nums2[k - 1] = nums2[k];
                        nums2[k] = key;
                        k++;
                    }
                }

            }
        }

    }

    private static double findMedian(int[] nums1, int[] nums2, int n1, int n2) {

        int medianIndex = (n1+n2)/2;
        if((n1+n2) % 2 == 0) { // even

            int i = getByIndex(nums1, nums2, n1, n2, medianIndex);
            int j = getByIndex(nums1, nums2, n1, n2, medianIndex + 1);
            return (i+j)/2d;

        } else { // odd
            return getByIndex(nums1, nums2, n1, n2, medianIndex + 1);
        }

    }

    private static int getByIndex(int[] nums1, int[] nums2, int n1, int n2, int m) {

        int index = m <= n1 ? nums1[m-1] : nums2[m-n1-1];
        return index;
    }
}
