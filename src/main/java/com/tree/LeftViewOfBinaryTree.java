package com.tree;

import com.tree.model.TreeNode;

/**
* Time Complexity is O(n)
  Space Complexity is O(1)
* */

public class LeftViewOfBinaryTree {

    /**
     * important
     */
    static int maxLevelSoFar = -1;

    public static void main(String args[]) {

    /*
          Binary Tree

              1
             / \
            2   3
           / \
          4   5
       */
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.right.left = new TreeNode(7);
        tree.right.right = new TreeNode(8);
        tree.left.left.left = new TreeNode(10);

        printLeftView(tree, 0);
    }

    private static void printLeftView(TreeNode tree, int currentLevel) {

        /**important*/ /**Base Condition */
        if (tree == null)
            return;

        if (currentLevel > maxLevelSoFar) {
            System.out.println(tree.val + " ");
            maxLevelSoFar = currentLevel;
        }

        /**Recursive condition */
        printLeftView(tree.left, currentLevel + 1); //if condition will be true for currentLevel
        printLeftView(tree.right, currentLevel + 1); //if condition will be false for same currentLevel

    }
}
