package com.techiekunal.codepractice.datastructures;

import java.util.LinkedList;
import java.util.Queue;

public class MyBST {

	private static class Node {
		int key;
		Node left;
		Node right;
		
		public Node(int item) {
			key = item;
			left = right = null;
		}
	}
	
	// code for BST functions are below
	Node root;
	
	public MyBST() {
		root = null;
	}
	
	public MyBST(int key) {
		root = new Node(key);
	}
	
	public static void main(String[] args) {
		
		// create a tree
		MyBST bst = new MyBST(1);
		
		bst.root.left = new Node(2);
		bst.root.right = new Node(3);
		
		bst.root.left.left = new Node(4);
		bst.root.left.right = new Node(5);
		new MyBST().levelOrderTraversal(bst);
	}
	
	
	public void levelOrderTraversal(MyBST bst) {
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(bst.root);
		while(!queue.isEmpty()) {
			
			Node tempNode = queue.poll();
			System.out.println(tempNode.key);
			
			if(tempNode.left != null) {
				queue.add(tempNode.left);
			}
			
			if(tempNode.right != null) {
				queue.add(tempNode.right);
			}
			
		}
	}
}
