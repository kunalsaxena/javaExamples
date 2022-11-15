package com.techiekunal.coding.interview.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FibonacciExample {

    private Map<Integer, Integer> fiboMap = new HashMap<>(); // used for memoization

    public static void main(String[] args) {
        int n = 5;
        FibonacciExample example = new FibonacciExample();

        System.out.println("Fibonacci number from Recur is - " + example.fiboRecur(n));

        System.out.println("Fibonacci number from Recur is - " + example.fiboIterative(n));
    }

    // Bottom Up approach | Iterative | Tabular method
    private int fiboIterative(int n) {
        int[] arr = new int[n+1];

        // init
        Arrays.fill(arr, -1);
        arr[0] = 0;
        arr[1] = 1;

        for(int i = 2; i <= n; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n];
    }

    // Top down approach | Recursion | Memoization method
    private int fiboRecur(int n) {

        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }

        if(fiboMap.containsKey(n)) {
            return fiboMap.get(n);
        }

        int res = fiboRecur(n-1) + fiboRecur(n-2);
        fiboMap.put(n, res);
        return res;
    }

}
