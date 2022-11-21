package com.techiekunal.coding.interview.other;

import java.util.*;

// Assumptions -
// calls are being made to the system in chronological order (ie, the timestamp is monotonically increasing)
// You may assume that the earliest timestamp starts at 1.

// Downsides of Queue implementation
//      - not optimal storage for 1 1 1 1 2 2
//      - hit O(1), getHit - remove old elements where timestamp - time >= 300 then take size | worst case O(n)
// Approach #2 - with HashMap - optimal storage | hit() - slightly more than O(1) | getHit() - O(n) + removing old elements
// So we get optimal time with queue but optimal space usage with map implementation

public class HitCounter {

    private static Deque<Integer> queue = new LinkedList<>();

    private void hit(int second) {
        queue.add(second);
    }

    private int getHits(int time) {
        removeOldHits(time);
        return queue.size();
    }

    private void removeOldHits(int time) {
        // remove old
        if(!queue.isEmpty() && time - queue.peekFirst() >= 300) {
            queue.poll();
        }
    }

    public static void main(String[] args) {
        HitCounter counter = new HitCounter();
        // hit at timestamp 1.
        counter.hit(1);

        // hit at timestamp 2.
        counter.hit(2);

        // hit at timestamp 3.
        counter.hit(3);

        // get hits at timestamp 4, should return 3.
        System.out.println(counter.getHits(4));

        // hit at timestamp 300.
        counter.hit(300);

        // get hits at timestamp 300, should return 4.
        System.out.println(counter.getHits(300));

        // get hits at timestamp 301, should return 3.
        System.out.println(counter.getHits(301));
    }

}
