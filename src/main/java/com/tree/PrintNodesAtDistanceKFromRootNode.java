package com.tree;

import com.tree.model.TreeNode;

public class PrintNodesAtDistanceKFromRootNode {

    public static void main (String args[]){

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.left.left  = new TreeNode(40);
        root.left.right = new TreeNode(50);

        int distance = 1;
        printNodesAtKDistanceFromRoot(root,distance);

    }

    private static void printNodesAtKDistanceFromRoot(TreeNode root, int distance) {
        /** Null check */
        if (root == null){
            return;
        }

        /**Base condition */
        if (distance == 0){
            System.out.println(root.val);
        }

        /** Recursive condition */
        else{
            printNodesAtKDistanceFromRoot(root.left,distance-1);
            printNodesAtKDistanceFromRoot(root.right, distance-1);
        }
    }

}
