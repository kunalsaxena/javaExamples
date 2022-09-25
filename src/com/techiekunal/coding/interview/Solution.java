package com.techiekunal.coding.interview;

public class Solution {

	//Function to find nth number made of only prime digits.
    public static int primeDigits(int n)
    {
        int currentNum = 1;
        int count = 0;
        while(count < n) {
            
            if(checkAllDigit(++currentNum)) {
                count++;
            }
        }
        return currentNum;
    }
    
    private static boolean checkAllDigit(int num) {
    	int temp = num;
    	while(temp > 0) {
            if(!primeTest(temp % 10)) {
                return false;
            }
            temp = temp / 10;
        }
    	return true;
    }
    
    private static boolean primeTest(int d){
    	
    	if(d < 2) {
    		return false;
    	}
        for(int i=2; i < d; i++) {
            if(d % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
		System.out.println("Prime is -" + primeDigits(10));
	}
	
}
