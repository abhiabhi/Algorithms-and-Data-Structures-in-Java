package com.tree;

import com.tree.model.TreeNode;

public class MirrorBinaryTree {

    public static void main (String args[]){

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.left.left  = new TreeNode(40);
        root.left.right = new TreeNode(50);

        mirrorBinaryTree(root);

    }

    private static void mirrorBinaryTree(TreeNode root) {

        if(root!= null){

            mirrorBinaryTree(root.left);
            mirrorBinaryTree(root.right);

            /** swap the left and right pointers */
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
         }
        return;
    }

}
