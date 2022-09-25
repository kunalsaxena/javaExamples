package com.techiekunal.codepractice.algorithms;
/**
 * source - https://www.youtube.com/watch?v=GUDLRan2DWM
 * @author Kunal Saxena
 * 
 * tags = slow run time - O(n^2), in-place sorting
 *
 */
public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = {2,5,8,6,7,11,3,1,9};
		selectionSort(arr, arr.length);
		
		System.out.println("After sorting");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	private static void selectionSort(int[] arr, int n) {
		
		for(int k = 0; k < n-1; k++) {
			
			// find minimum element from array in Each pass
			int min = k; // assume first element is min
			for(int i = k + 1; i < n; i++) {
				if(arr[i] < arr[min]) {
					min = i;
				}
			}
			
			// swap min element (selected) with current index
			int temp = arr[min];
			arr[min] = arr[k];
			arr[k] = temp;
		}
		
	}
	
}
