package com.techiekunal.codepractice.datastructures;

import java.util.Stack;

/**
 * used for finding next greater/smaller elements etc.
 * For next greater we are going to use decreasing monotonic stack
 */
public class MonotonicStackExample {

    public static void main(String[] args) {
        int[] arr = new int[]{2,7,4,3,5};
        System.out.println(buildMonotonicStack(arr));
    }

    private static Stack<Integer> buildMonotonicStack(int[] arr) {
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();

        for(int i = n-1; i >= 0; i--) {
            while(!stack.empty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            // Add the next greater element in the array
            System.out.println(stack.empty() ? 0 : stack.peek());
            stack.push(arr[i]);
        }
        return stack;
    }

}
