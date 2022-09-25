package com.techiekunal.codepractice.algorithms;

public class HeapSort {

	public static void main(String[] args) {
		
		int[] arr = {2,5,8,6,7,11,3,1,9};
		heapSort(arr);
		
		System.out.println("After sorting");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	private static void heapSort(int[] arr) {
		// build max heap - complexity O(n)
		int heapSize = arr.length;
		for(int i = heapSize/2; i >= 0; i--) {
			heapify(arr, heapSize, i);
		}
		
		// Now for sorting :: remove elements one by one and put it in array
		for(int i = heapSize - 1; i > 0; i--) {
			// move current root to the end
			int swap = arr[0];
			arr[0] = arr[i];
			arr[i] = swap;
			
			// call max-heapify on reduced heap
			heapify(arr, i, 0);
		}
	}
	
	private static void heapify(int[] arr, int n, int i) {
		
		int l = 2 * i + 1; // left index will be 2*i+1
		int r = 2 * i + 2; // right index will be 2*i+1
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
			
			heapify(arr, n, largest);
		}
	}
	
}
