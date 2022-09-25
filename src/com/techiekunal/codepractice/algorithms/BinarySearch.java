package com.techiekunal.codepractice.algorithms;

public class BinarySearch {

	public static void main(String[] args) {
		int arr[] = {2,4,5,7,9,11,14,15,20,22,23,24,25,26,27,28,32,33,36,37,39,41,42,43,44,45,47,48,49,50,51,53,54,55,57,59,60,61,62,63,66,67,68,69,70,71,72,73,74,76,78,86,87,89,91,93,94,95,97,100}; 
//		int arr[] = {1,2,3,4,5};
		
		Solution solution = new Solution();
		int result = solution.binarysearch(arr, 60, 1);
		System.out.print(result);
	}
	
}

class Solution {
    
	int binarysearch(int arr[], int n, int k) {
        int l = 0; 
        int r = n-1;
        return findwithBinarySearch(l, r, arr, k);
    }
    
    int findwithBinarySearch(int l, int r, int arr[], int k) {
                
        if(l <= r) {
        	
        	int m = (l+r)/2;
        
	        if(arr[m] == k) {
	            return m;
	        } 
	        else if(arr[m] < k) {
	            // move right
	             return findwithBinarySearch(m+1, r, arr, k);
	        }
	        else if(arr[m] > k) {
	            // move left
	             return findwithBinarySearch(l, m-1, arr, k);
	        }
	        
        } 
       	return -1;			
    }
}