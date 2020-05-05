package com.tree;


import com.tree.model.TreeNode;

import java.util.Stack;

/**
 * LEFT *ROOT* RIGHT
 *
 * It's worth remembering that the inOrder traversal is a depth-first algorithm and
 * prints the tree node in sorted order if given binary tree is a binary search tree.
 *
 * Visit left node
 * Print value of the root
 * Visit right node
 *
 */
public class DFSInorderTraversalOfTree {

    public static void main (String args[]){
       TreeNode root= create();
       inOrderTraversal(root);
        inorderStack(root);
    }

    /**
     * Recurssive Approach
     * @param root
     */
    private static void inOrderTraversal(TreeNode root) {
        if (root == null){
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.val + " ");
        inOrderTraversal(root.right);
    }

    /**Iterative Approach*/
    public static void inorderStack(TreeNode root)
    {
        Stack<TreeNode> s =new Stack<TreeNode>();
        while(true){

            // Go to the left extreme insert all the elements to stack
            while(root != null){
                s.push(root);
                root = root.left;
            }
            // check if Stack is empty, if yes, exit from everywhere
            if (s.isEmpty()) {
                return;
            }
            // pop the element from the stack , print it and add the nodes at
            // the right to the Stack
            root =s.pop();
            System.out.print(root.val + " ");
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
}
