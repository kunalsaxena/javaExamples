package com.techiekunal.codepractice.algorithms;

import java.util.Arrays;

/**
 * max-heap => root should be greater >= all child nodes
 * Build max-heap from array - O(n)
 * heapify - O(logn)
 * heap sort takes - O(nlogn) time
 */
public class HeapSort {

	public static void main(String[] args) {
		int[] arr = {2,5,8,6,7,11,3,1,9};
		heapSort(arr);
		System.out.println("After sorting");
		System.out.println(Arrays.toString(arr));
	}
	
	private static void heapSort(int[] arr) {
		// build max heap - complexity O(n)
		int heapSize = arr.length;
		for(int i = heapSize/2; i >= 0; i--) { // heapify all roots
			heapify(arr, heapSize, i);
		}
		// 11,9,8,6,7,2,3,1,5 >> max element will be present at 0' index after heapify
		// Sorting :: so remove 0 >> swap it with the end >> heapify
		for(int i = heapSize - 1; i > 0; i--) {
			// move current root to the end
			int swap = arr[0];
			arr[0] = arr[i];
			arr[i] = swap;
			
			// call max-heapify on reduced heap
			heapify(arr, i, 0);
		}
	}

	// decide largest among [i, 2i+1, 2i+2] and swap it with root
	private static void heapify(int[] arr, int n, int i) {
		
		int l = 2 * i + 1; // left index will be 2*i+1
		int r = 2 * i + 2; // right index will be 2*i+2
		int largest = i;
		
		if(l < n && arr[l] > arr[largest]) {
			largest = l;
		}
		if(r < n && arr[r] > arr[largest]) {
			largest = r;
		}
		// if root isn't largest
		if(largest != i) {
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;
			// Recursively heapify the affected sub-tree
			heapify(arr, n, largest);
		}
	}
	
}
