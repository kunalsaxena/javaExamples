package com.techiekunal.examples.concurrency;

import java.util.concurrent.Callable;

public class RetryUtils {

    public static <V> V retry(Callable<V> callable, RuntimeException throwable, String message, int retryCount, boolean isFatal) {
        return retryLogic(callable, throwable, message, retryCount, isFatal);
    }

    private static <T> T retryLogic(Callable<T> callable, RuntimeException throwable, String message, int retryCount, boolean isFatal) {
        // you can also have custom backoff timer
        int counter = 1;
        while (counter <= retryCount) {
            try {
                T retVal = callable.call();
                // first attempt - don't log
                return retVal;
            } catch (Exception e) {
                // LOG - trying attempt number
                counter++;
                try {
                    Thread.sleep(3000); // 3 sec
                } catch (Exception e1) {
                    // LOG : log the error
                }

                if(throwable == null && counter > retryCount) {
                    throwable = new RuntimeException(message, e);
                }
            }
        }
        // log - max retry exhausted | now giveup
        if(isFatal) {
            // exit the process
        }
        throw throwable;
    }
}
