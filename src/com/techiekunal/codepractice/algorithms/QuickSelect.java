package com.techiekunal.codepractice.algorithms;

public class QuickSelect {

	public static void main(String[] args) {
		
		int[] arr = {7,10,4,3,20,15};
		int selectedMin = quickSelect(arr, 0, arr.length-1, 2); // 4th min means - array index 3
		
		System.out.println("After Selection");
		
		System.out.print(selectedMin + " is the element ");
	}
	
	private static int quickSelect(int[] arr, int start, int end, int k) {
		
		int pi = partition(arr, start, end);
		
		if(pi < k) {
			return quickSelect(arr, pi + 1, end, k);
		}
		else if(pi > k) {
			return quickSelect(arr, start, pi - 1, k);
		} else {
			return arr[pi];
		}
	}
	
	private static int partition(int[] arr, int start, int end) {
		
		int pivot = arr[end];
		int pi = start;
		
		for(int i = start; i < end; i++) {
			
			if(arr[i] <= pivot) {
				int swap = arr[pi];
				arr[pi] = arr[i];
				arr[i] = swap;
				pi++;
			}
		}
		
		// swap pi and end (pivot)
		int temp = arr[pi];
		arr[pi] = arr[end];
		arr[end] = temp;
		
		return pi;
	}
}
