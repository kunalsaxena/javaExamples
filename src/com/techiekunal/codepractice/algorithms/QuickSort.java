package com.techiekunal.codepractice.algorithms;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = {2,5,8,6,7,11,3,1,9};
		quickSort(arr, 0, arr.length - 1);
		
		System.out.println("After sorting");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	private static void quickSort(int[] arr, int start, int end) {
		
		if(start < end) {
			int pi = partition(arr, start, end);
			quickSort(arr, start, pi - 1);
			quickSort(arr, pi + 1, end);
		}
	}
	/**
	 * pivot is last element of array
	 * pi - partition index :: 
	 * all elements < pivot should be left of pi
	 * all elements > pivot should be right of pi 
	 * 	
	 */
	private static int partition(int[] arr, int start, int end) {
		
		int pivot = arr[end];
		int pi = start;
		
		for(int i = start; i < end; i++) {
			
			if(arr[i] <= pivot) { // elements < pivot should be left of pi :: swap arr[i] with arr[pi]
				int temp = arr[i];
				arr[i] = arr[pi];
				arr[pi] = temp;
				pi++;
			}
		}
		
		// swap pi and pivot in the end
		int temp = arr[pi];
		arr[pi] = arr[end];
		arr[end] = temp;
		
		return pi;
	}
	
}
