package com.techiekunal.codepractice.algorithms;

public class MergeSort {

	public static void main(String[] args) {
		
		int[] arr = {1, 5, 7, 2, 4, 9, 12, 3, 6};
		int length = arr.length;
		
		System.out.println("Before sorting");
		for(int i = 0; i < length; i++) {
			System.out.print(arr[i] + " ");
		}
		
		sort(arr, 0, arr.length-1);
		
		System.out.println("After sorting");
		for(int i = 0; i < length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	private static void sort(int[] arr, int p, int r) {
		
		if(p < r) {
			int q = (p + r)/2;
			sort(arr, p, q); 	  // left
			sort(arr, q+1, r); 	  // right
			merge(arr, p, q, r);  // merge
		}
	}
	
	private static void merge(int[] arr, int p, int q, int r) {
		
		// divide this into two subarrays : pivot - q
		int n1 = q - p + 1;
		int n2 = r - q;
		
		int[] leftArr = new int[n1];
		int[] rightArr = new int[n2];
		
		// make left and right piles of cards
		for(int i = 0; i < n1; i++) {
			leftArr[i] = arr[p + i]; 
		}
		
		for(int j = 0; j < n2; j++) {
			rightArr[j] = arr[q + 1 + j]; 
		}
				
		// compare
		int k = p;
		int i = 0, j = 0;
		// run till both piles have cards :: put smaller card in final pile
		while(i < n1 && j < n2) {
			
			if(leftArr[i] <= rightArr[j]) {
				arr[k] = leftArr[i];
				i++;
			} else {
				arr[k] = rightArr[j];
				j++;
			}
			k++;
		}
		
		//copy remaining elements from first pile if any
		while(i < n1) {
			arr[k] = leftArr[i];
			i++;
			k++;
		}
		
		//copy remaining elements from second pile if any
		while(j < n2) {
			arr[k] = rightArr[j];
			j++;
			k++;
		}
	}
	
}
