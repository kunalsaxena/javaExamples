package com.techiekunal.coding.interview.array;

import java.util.Scanner;

public class ArrayReverse {

	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0; i < t; i++) {
			
			int n = sc.nextInt();
			int[] arr = new int[n];
			
			for(int j = 0; j < n; j++) {
				arr[j] = sc.nextInt();
			}
			reverseArray(arr, n);
		}
	}
	
	private static void reverseArray(int[] arr, int n) {
		for(int i = n-1; i >= 0; i--) {
			System.out.print(arr[i] + " ");
		}
	}
	
}
