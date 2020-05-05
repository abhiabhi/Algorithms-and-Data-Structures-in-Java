package com.tree;

import com.tree.model.TreeNode;

import java.util.Stack;

/**
 * *ROOT* LEFT RIGHT
 */
public class DFSPreOrderTraversalOfBinaryTree {

    /**
     * Recurssive Approach
     *
     * @param root
     */
    private static void preOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    /**
     * Iterative Approach
     */
    public static void preOrderStack(TreeNode root) {
        Stack<TreeNode> s = new Stack<TreeNode>();

        while (true) {
            // First print the root node and then add left node
            while (root != null) {
                System.out.print(root.val + " ");
                s.push(root);
                root = root.left;
            }
            // check if Stack is emtpy, if yes, exit from everywhere
            if (s.isEmpty()) {
                return;
            }
            // pop the element from the stack and go right to the tree
            root = s.pop();
            root = root.right;
        }
    }


    /**
     * Java method to create binary tree with test data
     *
     * @return a sample binary tree for testing
     */
    public static TreeNode create() {
        TreeNode root = new TreeNode(40);
        root.left = new TreeNode(20);
        root.left.left = new TreeNode(10);
        root.left.left.left = new TreeNode(5);
        root.left.right = new TreeNode(30);
        root.right = new TreeNode(50);
        root.right.right = new TreeNode(60);
        root.left.right.left = new TreeNode(67);
        root.left.right.right = new TreeNode(78);
        return root;
    }

    public static void main(String args[]) {
        TreeNode root = create();
        preOrderStack(root);
    }
}
