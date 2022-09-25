package com.techiekunal.coding.interview;

import java.util.ArrayList;
import java.util.Scanner;

public class SubArrayGivenSum {
	
	public static void main(String[] args) {
		
		/*
		 * Scanner sc = new Scanner(System.in);
		 * System.out.println("Enter total elements in array"); int n = sc.nextInt();
		 * System.out.println("Enter expected sum"); int s = sc.nextInt();
		 * System.out.println("Enter array elements"); int[] arr = new int[n]; for(int i
		 * = 0; i < n; i ++) { arr[i] = sc.nextInt(); }
		 */
		
		int[] arr = {1,2,3,7,5};
		ArrayList<Integer> subarr = subarraySum(arr, 5, 12);
		
		for(int i = 0; i < subarr.size(); i++) {
			System.out.print(subarr.get(i) + " ");
		}
		System.out.println();
	}

	static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        int currentSum = 0;
        int left = 0, right = 0;
        while(left < n) {
            
            if(currentSum == s) {
                System.out.println(" Final - left = " + left + " and right = " + right);
                
                return toArrayListRange(arr, left, right-1);
            }
            else if(currentSum < s && right < n) {
                currentSum = currentSum + arr[right];
                right++;
            } else {
                currentSum = currentSum - arr[left];
                left++;
            }
            System.out.println(" left = " + left + " and right = " + right);
        }
        return new ArrayList<Integer>(){{add(-1);}};
    }
    
    static ArrayList<Integer> toArrayListRange(int[] arr, int left, int right) {
        ArrayList<Integer> arrList = new ArrayList<>();
        
        for(int i = left; i <= right; i++) {
            arrList.add(arr[i]);    
        }
        return arrList;
    }
}
