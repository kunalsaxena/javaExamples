package com.techiekunal.coding.interview.hashing;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LoggerRateLimiter {

    private static Map<String, Integer> messageToTimeMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        LoggerRateLimiter logger = new LoggerRateLimiter();

        // logging string "foo" at timestamp 1
        System.out.println(logger.shouldPrintMessage(1, "foo"));

        // logging string "bar" at timestamp 2
        System.out.println(logger.shouldPrintMessage(2,"bar"));

        // logging string "foo" at timestamp 3
        System.out.println(logger.shouldPrintMessage(3,"foo"));

        // logging string "bar" at timestamp 8
        System.out.println(logger.shouldPrintMessage(8,"bar"));

        // logging string "foo" at timestamp 10
        System.out.println(logger.shouldPrintMessage(10,"foo"));

        // logging string "foo" at timestamp 11
        System.out.println(logger.shouldPrintMessage(11,"foo"));
    }

    public static boolean shouldPrintMessage(int timestamp, String name) {
        Integer prev = messageToTimeMap.getOrDefault(name, 0); // returns previous value or null
        if(prev == 0 || timestamp - prev >= 10) {
            messageToTimeMap.put(name, timestamp);
            return true;
        }
        return false;
    }
}
