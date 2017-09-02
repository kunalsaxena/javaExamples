package com.techiekunal.codepractice.geeks;

import java.util.Arrays;
import java.util.Scanner;

public class KadanesAlgorithm {

	public static void main(String[] args) {
		
		int testCaseCount = 0;
		int elementsCount = 0;
		int[] arr;
		Scanner scan = new Scanner(System.in);
		testCaseCount = scan.nextInt();
		
		System.out.println("No of tests are :" + testCaseCount);
		
		for(int i = 0; i < testCaseCount; i++) {
			elementsCount = scan.nextInt();
			arr = new int[elementsCount];
			for(int j = 0; j < elementsCount; j++) {
				arr[j] = scan.nextInt();
			}
			
			int sum = new KadanesAlgorithm().calcSum(arr);
			
			System.out.println("No of elements are :" + elementsCount);
			System.out.println("elements are :" + Arrays.toString(arr));
			
			System.out.println("sum is :" + sum);
		}
		
		scan.close();
	}
	
	private int calcSum(int[] arr) {
		int sum = arr[0];
		int max = sum;
		for(int i = 0;i < arr.length-1; i++) {
			
			if((arr[i+1] == arr[i] + 1)) {
				sum = sum + arr[i+1];
				if(sum > max) {
					max = sum;
				}
			} else if(arr[i+1] == arr[i] - 1) {
				sum = sum + arr[i+1];
				if(sum < max) {
					max = sum;
				}
			} else {
				sum = 0;
			}
		}
		return max;
	}
	

}
