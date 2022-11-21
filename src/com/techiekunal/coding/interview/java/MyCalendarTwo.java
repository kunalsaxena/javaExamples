package com.techiekunal.coding.interview.java;

import java.util.*;

public class MyCalendarTwo {

    private final List<int[]> eventsList;
    private final Map<Integer, Integer> overlapFreqMap;

    public MyCalendarTwo() {
        eventsList = new ArrayList();
        overlapFreqMap = new HashMap<>();
    }

    public boolean book(int start, int end) {

        int overlapIndex = getOverLapEvent(start, end);

        int freq = overlapFreqMap.getOrDefault(overlapIndex, 0);

        if(freq >= 2) { // double booked and overlap
            System.out.println(start + "-" + end + " | " + freq + " # " + overlapIndex);
            return false;
        }

        if(overlapIndex == -1) { // no overlap
            overlapIndex = start;
        }
        addToCalendar(start, end);
        updateEventFreq(overlapIndex, freq);
        return true;
    }

    private void addToCalendar(int start, int end) {
        int[] event = {start, end};
        eventsList.add(event);
//        Collections.sort(eventsList, Comparator.comparingInt(e -> e[0]));
    }

    private void updateEventFreq(int start, int freq) {
        overlapFreqMap.put(start, freq + 1);
    }

    private int getOverLapEvent(int start, int end) {
        int index = -1;
        for(int i=0; i<eventsList.size(); i++) {
            int[] event = eventsList.get(i);
            if(! (end <= event[0] && end < event[1] || start > event[0] && start >= event[1]) ) {
                index = event[0];
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        MyCalendarTwo obj = new MyCalendarTwo();

        String[] command = {"book","book","book","book","book","book"};
        int[][] timings =  {{10,20},{50,60},{10,40},{5,15},{5,10},{25,55}};
        boolean[] result = {true,true,true,false,true,true};

        for(int i=0; i<command.length; i++) {
            if("book".equals(command[i])) {
                boolean actual = obj.book(timings[i][0], timings[i][1]);
                if(actual == result[i]) {
                    System.out.println("Matched.");
                } else {
                    System.out.println("Didn't match - " + Arrays.toString(timings[i]));
                }
            }
        }
        obj.eventsList.forEach(a -> System.out.print(Arrays.toString(a)));
        System.out.println();
        System.out.println(obj.overlapFreqMap);
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
