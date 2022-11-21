package com.techiekunal.examples.concurrency;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

public class PoolExecuter<RESPONSE> {

    // logger
    private final ThreadPoolExecutor threadPoolExecutor;
    private final int futureSharedTimeoutInSec;

    // you will get these from property file - config object and call this
    public PoolExecuter(int threadPoolSize, int aliveTime, int timeout) {
        this.futureSharedTimeoutInSec = timeout;
        threadPoolExecutor = new ThreadPoolExecutor(threadPoolSize, threadPoolSize, aliveTime, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
    }

    public Collection<RESPONSE> execute(Collection<Callable<RESPONSE>> callables) {
        LinkedList<Future<RESPONSE>> futures = new LinkedList<>();
        List<RESPONSE> responseList = new ArrayList<>();
        // processing & logic

        for(Callable<RESPONSE> callable : callables) {
            futures.add(threadPoolExecutor.submit(callable));
        }

        long timeout = System.currentTimeMillis() + futureSharedTimeoutInSec * 1000;

        while (System.currentTimeMillis() < timeout && !futures.isEmpty()) {
            List<Future> completed = new ArrayList<>();
            for(Future<RESPONSE> future : futures) {
                if(future.isDone()) {
                    try {
                        RESPONSE response = future.get();
                    } catch (Exception e) {
                        // log error & add to exception
                    } finally {
                        completed.add(future);
                    }
                }
            }

            futures.removeAll(completed);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // Thread interrupted with getMessage()
            }
        }

        for(Future future : futures) {
            if(!future.cancel(true)) {
                // potentially hung thread, failed to cancel future
            }
        }

        // shutdown
        try {
            if(!threadPoolExecutor.isShutdown()) {
                threadPoolExecutor.shutdown();
                if(threadPoolExecutor.awaitTermination(180, TimeUnit.SECONDS)) {
                    threadPoolExecutor.shutdownNow();
                }
            }
        } catch (Exception e) {
            // log exception
        }

        return responseList;
    }



}
