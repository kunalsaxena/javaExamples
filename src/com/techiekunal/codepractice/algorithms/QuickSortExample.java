package com.techiekunal.codepractice.algorithms;

import java.util.Arrays;

public class QuickSortExample {

	public static void quicksort(int[] arr, int left, int right) {
		if(left >= right)
			return;
		
		int pivot = arr[(left + right) / 2];
		int index = partition(arr, left, right, pivot);
		quicksort(arr, left, index-1);
		quicksort(arr, index, right);
	}
	
	// every recursion is a level
	// average running time is O (n log n). because average call depth is like btree, log n. 
	// And each level of the call tree processes at most n elements. So total is O (n log n)
	private static int partition(int[] arr, int left, int right, int pivot) {
		while(left <= right) {
			while(arr[left] < pivot) {
				left++;
			}
			while(arr[right] > pivot) {
				right--;
			}
			if(left <= right) {
				swap(arr, left, right);
				left++;
				right--;
			}
		}
		return left;
	}

	private static void swap(int[] arr, int left, int right) {
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}

	public static void main(String[] args) {
		int[] arr = {7,8,4,1,2,6,3,9,5};
		System.out.println("Array before sorting " + Arrays.toString(arr));
		quicksort(arr, 0, arr.length-1);
		System.out.println("Array after sorting " + Arrays.toString(arr));
	}
	
}
