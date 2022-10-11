package com.techiekunal.codepractice.datastructures;

public class MySinglyLinkedList {

    private ListNode head;

    public static class ListNode {

        public int val;
        public ListNode next;

        public ListNode() {
            this(0, null);
        }

        public ListNode(int val) {
            this(val, null);
        }

        public ListNode(int val, ListNode node) {
            this.val = val;
            this.next = node;
        }
    }

    public ListNode createListFromArray(int[] arr) {
        ListNode newHead = new ListNode(arr[0]);
        this.head = newHead;
        for(int i=1; i<arr.length; i++) {
            addNode(new ListNode(arr[i]));
        }
        return newHead;
    }

    public void printList(ListNode head) {
        while(head != null) {
            System.out.print(head.val + " > ");
            head = head.next;
        }
    }

    private void addNode(ListNode node) { // added at end
        while (head.next != null) {
            head = head.next;
        }
        head.next = node;
    }
}
