package com.techiekunal.codepractice.datastructures;

public class MyOwnLinkedList {

    private Node first;

    private Node last;

    private int size;

    static class Node {

        Node left;
        Node right;
        int data;

        Node(Node left, int data, Node right) {
            this.left = left;
            this.right = right;
            this.data = data;
        }
    }

    // add
    public boolean add(int num) {
        // link last
        Node l = last;
        Node newNode = new Node(l, num, null);
        last = newNode;
        if(l == null) {
            first = newNode;
        } else {
            l.right = newNode;
        }
        size++;
        return true;
    }

    // removes element with lowest index
    // doesn't alter if element doesn't exists
    // data of element can be null and if remove called with null, it will remove node which has null data
    public boolean remove(int num){
        for(Node i = first; i.right != null; i = i.right) {
            if(i.data == num) {
                Node left = i.left;
                Node right = i.right;
                left.right = right;
                right.left = left;
                size--;
                return true;
            }
        }
        return false;
    }

    public int getSize() {
        return size;
    }

}