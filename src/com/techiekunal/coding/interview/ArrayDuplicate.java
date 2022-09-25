package com.techiekunal.coding.interview;

public class ArrayDuplicate {
	
	public static void main(String[] args) {
		int[] arr = {3,1,3,4,2};
		System.out.print(findDupe(arr));
	}
	
	private static int findDuplicate(int[] nums) {
		
        for(int i = 0; i < nums.length; i++){
            
            for(int j = i+1; j < nums.length; j++) {
                
                if(nums[i] == nums[j]){
                    return nums[i];
                }
            }
        }
        return -1;
    }
	
	// O(n) method
	// condition - nums[i] always be < n
	private static int findDupe(int[] nums) {
		int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        fast = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
	}
}
