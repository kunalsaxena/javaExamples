package com.techiekunal.coding.interview.java;

import java.util.Arrays;
import java.util.List;

public class TimeDiff {

    public static void main(String[] args) {
        calcTimeDiffInMinutes();
    }

    private static int calcTimeDiffInMinutes() {
        String[] arr = {"00:00", "04:00", "22:00"};
        TimeDiff timeDiff = new TimeDiff();
        List<String> list = (Arrays.asList(arr));
        int diff = timeDiff.calcTimeDiff(list.get(0), list.get(1));
        System.out.println("Time diff - " + diff);
        return diff;
    }

    private int calcTimeDiff(String t1, String t2) {

        int midnight = 24*60;
        String[] t1arr = t1.split(":");
        String[] t2arr = t2.split(":");

        int time1 = Integer.valueOf(t1arr[0])  * 60 + Integer.valueOf(t1arr[1]);
        int time2 = Integer.valueOf(t2arr[0])  * 60 + Integer.valueOf(t2arr[1]);

        return Math.min(Math.min(midnight - time1 + time2, midnight - time2 + time1), Math.abs(time1 - time2));
    }


}
