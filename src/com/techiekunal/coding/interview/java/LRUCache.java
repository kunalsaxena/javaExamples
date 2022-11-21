package com.techiekunal.coding.interview.java;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Source - https://www.baeldung.com/java-lru-cache
 * impl - https://www.dineshonjava.com/implement-lru-cache-algorithm-in-java/
 * problems with LinkedHashMap impl - searching and re-adding key to end of map -> to mark it latest >> O(n) or O(logn) itself
 */
public class LRUCache {

    private final Map<Integer, Node> map;
    private Node head;
    private Node tail;
    private final Integer capacity;

    public LRUCache(int capacity) {
        this.map = new ConcurrentHashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = map.get(key);
        if(node == null) {
            return -1;
        }
        removeNode(node);
        addToTail(node);
        return node.value;
    }

    private void removeNode(Node node) { // head middle node
        if(node.prev == null) { // head
            head = node.next;
        } else {
            node.prev.next = node.next;
        }

        if(node.next == null) {
            tail = node.prev;
        } else {
            node.next.prev = node.prev;
        }
    }

    private void addToTail(Node node) {
        // take example of adding 1st and 2nd element
        if(tail != null) {
            tail.next = node;
        }
        node.prev = tail;
        node.next = null;
        tail = node;
        if(head == null) {
            head = tail;
        }
    }

    public void put(int key, int value) {

        if(map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            // move to tail
            removeNode(node);
            addToTail(node);
        } else {
            if(map.size() >= capacity) {
                map.remove(head.key);
                removeNode(head);
            }
            Node node = new Node(key, value);
            addToTail(node);
            map.put(key, node);
        }
    }

    private void printDebug() {
//        System.out.println("freq - " + freqQueue);
//        System.out.println("map - " + storageMap);
    }

    // Failure cases-
    // 1. replacing value in map
    //

    public static void main(String[] args) {
        String[] command = {"LRUCache","put","put","put","put","put","get","put","get","get","put","get","put","put","put","get","put","get","get","get","get","put","put","get","get","get","put","put","get","put","get","put","get","get","get","put","put","put","get","put","get","get","put","put","get","put","put","put","put","get","put","put","get","put","put","get","put","put","put","put","put","get","put","put","get","put","get","get","get","put","get","get","put","put","put","put","get","put","put","put","put","get","get","get","put","put","put","get","put","put","put","get","put","put","put","get","get","get","put","put","put","put","get","put","put","put","put","put","put","put"};
        int[][] elements = {{10},{10,13},{3,17},{6,11},{10,5},{9,10},{13},{2,19},{2},{3},{5,25},{8},{9,22},{5,5},{1,30},{11},{9,12},{7},{5},{8},{9},{4,30},{9,3},{9},{10},{10},{6,14},{3,1},{3},{10,11},{8},{2,14},{1},{5},{4},{11,4},{12,24},{5,18},{13},{7,23},{8},{12},{3,27},{2,12},{5},{2,9},{13,4},{8,18},{1,7},{6},{9,29},{8,21},{5},{6,30},{1,12},{10},{4,15},{7,22},{11,26},{8,17},{9,29},{5},{3,4},{11,30},{12},{4,29},{3},{9},{6},{3,4},{1},{10},{3,29},{10,28},{1,20},{11,13},{3},{3,12},{3,8},{10,9},{3,26},{8},{7},{5},{13,17},{2,27},{11,15},{12},{9,19},{2,15},{3,16},{1},{12,17},{9,1},{6,19},{4},{5},{5},{8,1},{11,7},{5,2},{9,28},{1},{2,2},{7,4},{4,22},{7,24},{9,26},{13,28},{11,26}};
        Integer[] result = {null,null,null,null,null,null,-1,null,19,17,null,-1,null,null,null,-1,null,-1,5,-1,12,null,null,3,5,5,null,null,1,null,-1,null,30,5,30,null,null,null,-1,null,-1,24,null,null,18,null,null,null,null,-1,null,null,18,null,null,-1,null,null,null,null,null,18,null,null,-1,null,4,29,30,null,12,-1,null,null,null,null,29,null,null,null,null,17,22,18,null,null,null,-1,null,null,null,20,null,null,null,-1,18,18,null,null,null,null,20,null,null,null,null,null,null,null};
        LRUCache lruCache = null;
        for(int i=0; i<command.length; i++) {
//            System.out.println("Command - " + command[i] + " !! with element - " + Arrays.toString(elements[i]) + " !! expected - " + result[i]);

            if("LRUCache".equals(command[i])) {
                lruCache = new LRUCache(elements[i][0]);
            }
            else if("get".equals(command[i])) {
                int actual = lruCache.get(elements[i][0]);
                if(actual == result[i]) {
//                    System.out.println("Matched.");
                } else {
                    System.out.println("Didn't match - " + Arrays.toString(elements[i]));
                }
            } else if("put".equals(command[i])) {
                lruCache.put(elements[i][0], elements[i][1]);
            }
//            System.out.println("--------------------------**********************************-----------------------------");
        }
    }
}

class Node {
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.prev = prev;
        this.next = next;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */