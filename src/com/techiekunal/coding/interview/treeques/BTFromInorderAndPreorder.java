package com.techiekunal.coding.interview.treeques;

import com.techiekunal.codepractice.datastructures.TreeNode;
import com.techiekunal.codepractice.datastructures.TreeTraversalExamples;

import java.util.Arrays;
import java.util.HashMap;

public class BTFromInorderAndPreorder {

    private static HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode root = buildTree(preorder, inorder);
        System.out.println("Pre order new B Tree");
        TreeTraversalExamples.traversePreOrder(root);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        int rootIndex = findRootPreOrder(preorder, inorder);
        TreeNode root = new TreeNode(inorder[rootIndex]);

        int[] left = Arrays.copyOfRange(inorder, 0, rootIndex);
        int[] right = Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length);

        if(left.length != 0) {
            root.left = buildTree(preorder, left);
        }
        if(right.length != 0) {
            root.right = buildTree(preorder, right);
        }
        return root;
    }

    private static int findRootPreOrder(int[] preorder, int[] inorder) {
        if(inorder.length == 1) {
            return 0;
        }

        if(map.size() != preorder.length) {
            for(int j = 0; j < preorder.length; j++) {
                map.put(preorder[j], j);
            }
        }

        int inIndex = Integer.MAX_VALUE;
        int preIndex = Integer.MAX_VALUE;

        for(int i = 0; i < inorder.length; i++) {

            int index = map.get(inorder[i]);
            if(index < preIndex){
                preIndex = index;
                inIndex = i;
            }
        }
        return inIndex;
    }

}
