package com.techiekunal.coding.interview;

public class MergeSortedArrays {

	public static void main(String[] args) {
		
		int n = 4;
		int m = 5;
		
		long[] arr1 = { 1, 3, 5, 7};
		long[] arr2 = {0, 2, 6, 8, 9};
		
		merge(arr1, arr2, n, m);
		
		for(int i = 0; i < n; i++) {	
			System.out.print(arr1[i]);
		}
		for(int i = 0; i < m; i++) {
			System.out.print(arr2[i]);
		}
		
	}
	
	
	//Function to merge the arrays.
    public static void merge(long arr1[], long arr2[], int n, int m) 
    {
        long temp;
        // code here 
        for(int i=0; i < n; i++){
            
            for(int j=0; j<m; j++){
                
                if(arr1[i] > arr2[j]) {
                    temp = arr1[i];
                    arr1[i] = arr2[j];
                    arr2[j] = temp;
                }    
            }
            
        }
        
        for(int i = 1; i < m; i++) {
            
            long key = arr2[i];
            int j = i-1;
            
            while(j >= 0 && arr2[j] < key) {
                arr2[j+1] = arr2[j];
                j = j-1;
            }
            arr2[j+1] = key;
        }
    }
}
