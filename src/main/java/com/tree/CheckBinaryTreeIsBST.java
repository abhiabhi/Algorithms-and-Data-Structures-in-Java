package com.tree;

import com.tree.model.TreeNode;

public class CheckBinaryTreeIsBST {

    public static void main(String args[]) {

    /*
          Binary Tree

              1
             / \
            2   3
           / \
          4   5
       */
        TreeNode tree = new TreeNode(10);
        tree.left = new TreeNode(8);
        tree.right = new TreeNode(30);
        tree.left.left = new TreeNode(6);
        tree.left.right = new TreeNode(9);
        tree.right.left = new TreeNode(15);
        tree.right.right = new TreeNode(35);
        tree.left.left.left = new TreeNode(4);


        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;

        System.out.println("Is Binary Search Tree:" + isBST(tree,min,max));
    }

    /**Returns true if the given tree is a BST and its
      values are >= min and <= max. */
    private static boolean isBST(TreeNode node, int min, int max) {

        /* an empty tree is BST */
        if (node == null)
            return true;

        /**important*/
        /** false if this node violates the min/max constraints */
        if(node.val < min || node.val >max){
            return false;
        }

         /** otherwise check the subtrees recursively
        tightening the min/max constraints */
        // Allow only distinct values
        return isBST(node.left,min,node.val-1) && isBST(node.right, node.val+1, max);
    }
}
