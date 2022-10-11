package com.techiekunal.codepractice.datastructures;

import java.util.LinkedList;
import java.util.Queue;

public class TreeTraversalExamples {

    TreeNode root;

    public static TreeNode buildSampleBTree() {

        TreeNode root = new TreeNode(8);

        TreeNode two = new TreeNode(2);
        TreeNode five = new TreeNode(5);

        attachChild(root, two, five);

        TreeNode four = new TreeNode(4);
        TreeNode three = new TreeNode(3);

        attachChild(two, four, three);

        TreeNode one = new TreeNode(1);
        TreeNode nine = new TreeNode(9);
        attachChild(four, one, nine);

        TreeNode n7 = new TreeNode(7);
        attachChild(five, null, n7);

        TreeNode n6 = new TreeNode(6);
        attachChild(n7, n6, null);

        return root;
    }

    private static void attachChild(TreeNode node, TreeNode left, TreeNode right) {
        node.left = left;
        node.right = right;
    }

    // gives sorted sequence in case of BST
    public static void traverseInOrder(TreeNode root) {
        // inOrder - L data R
        if(root.left != null) {
            traverseInOrder(root.left);
        }
        System.out.print(root.data + " > ");
        if(root.right != null) {
            traverseInOrder(root.right);
        }
    }

    public static void traversePreOrder(TreeNode root) {
        // PreOrder - data L R
        System.out.print(root.data + " > ");
        if(root.left != null) {
            traversePreOrder(root.left);
        }
        if(root.right != null) {
            traversePreOrder(root.right);
        }
    }

    // covers tree from bottom
    public static void traversePostOrder(TreeNode root) {
        // PreOrder - L R data
        if(root.left != null) {
            traversePostOrder(root.left);
        }
        if(root.right != null) {
            traversePostOrder(root.right);
        }
        System.out.print(root.data + " > ");
    }

    public static void levelOrderTraversal(Queue<TreeNode> queue) {

        TreeNode root = queue.poll();
        if(root == null) {
            return;
        }
        System.out.print(root.data + " > ");
        if(root.left != null) {
            queue.add(root.left);
        }
        if(root.right != null) {
            queue.add(root.right);
        }
        levelOrderTraversal(queue);
    }

    //private static boolean nodeFound = false;


    public static TreeNode deleteNode(TreeNode root, int k) {

        // do pre order traversal
        if(root == null) { // base case
            return null;
        }

        if(root.data == k) { // we traverse till the node to be deleted
            // case 1 - 0 child => delete leaf node
            if (root.left == null && root.right == null) {
                root = null;
            }
            // case 2 - 1 child
            else if (root.left == null || root.right == null) {
                root = root.left == null ? root.right : root.left;
            }
            // case 3 - 2 child
            else {
                // preferring to replace with right child
                TreeNode temp = findLeftMostOnRight(root.right);
                root.data = temp.data;
                root.right = deleteNode(temp.right, temp.data);
            }
        }
        if(root!= null && root.left != null) {
            root.left = deleteNode(root.left, k);
        }
        if(root!= null && root.right != null) {
            root.right = deleteNode(root.right, k);
        }
        return root;
    }

    private static TreeNode findLeftMostOnRight(TreeNode root) { // similar to find minimum node on right - in case of BST
        if(root.left == null || root == null) {
            return root;
        }
        return findLeftMostOnRight(root.left);
    }


    public static void main(String[] args) {
        TreeNode root = buildSampleBTree();
        System.out.println("\n Traversing In Order");
        traverseInOrder(root);

        System.out.println("\n\n Traversing Pre Order");
        traversePreOrder(root);
        System.out.println();

        System.out.println("\n Traversing Post Order");
        traversePostOrder(root);

        System.out.println("\n\n Traversing Level Order");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        levelOrderTraversal(queue);

        System.out.println("\n\n After deleting node : In order");
        TreeNode newHead = deleteNode(root, 2);
        traverseInOrder(newHead);
    }
}
