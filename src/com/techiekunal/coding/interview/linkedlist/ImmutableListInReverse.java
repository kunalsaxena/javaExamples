package com.techiekunal.coding.interview.linkedlist;

import com.techiekunal.codepractice.datastructures.MySinglyLinkedList;
import com.techiekunal.codepractice.datastructures.MySinglyLinkedList.ListNode;


/**
 * We want to print immutable list in reverse
 * here immutable will mean we can't do head = head.next | can't modify elements, only traverse
 * other condition is - no extra space
 */
public class ImmutableListInReverse {

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,9};


        MySinglyLinkedList msll = new MySinglyLinkedList();
        ListNode head = msll.createListFromArray(arr);
        msll.printList(head);

        System.out.println("");
        System.out.println("Printing in reverse - ");
        printInReverse(head);
    }

    private static void printInReverse(ListNode head) {
        if(head == null) {
            return;
        }
        printInReverse(head.next);
        System.out.print(head.val + " > ");
    }

}
