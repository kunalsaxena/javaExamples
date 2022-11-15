package com.techiekunal.codepractice.algorithms;

/**
 * Source - https://www.youtube.com/watch?v=Jdtq5uKz
 * @author Kunal Saxena
 * 
 * Best case - if already sorted - O(n)
 * Avg/worst case - O(n^2)
 */
public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = {2,5,8,6,7,11,3,1,9};
		bubbleSort(arr, arr.length);
		
		System.out.println("After sorting");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	// bubble sorted/max element to the end in every pass
	private static void bubbleSort(int[] arr, int n) {
		
		for(int k = 0; k < n; k++)  {

			boolean isSwapped = false; // if no swap then array is already sorted
			// Each Pass
			for(int i=0; i < n-1-k; i++) { // -k is optimization
				if(arr[i] > arr[i+1]) {
					int swap = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = swap;
					isSwapped = true;
				}
			}
			if(!isSwapped) {
				break;
			}
		}
	}
}
