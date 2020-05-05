package com.tree;

import com.tree.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * printLevelorder(tree)
 * 1) Create an empty queue q
 * 2) temp_node = root /*start from root
 * 3)Loop while temp_node is not NULL
         *a)print temp_node->data.
         *b)Enqueue temp_node’s children(first left then right children)to q
         *c)Dequeue a node from q and assign it’s value to temp_node
 */
public class BFSorLevelOrderTraversalOfBinaryTree {

    public static void main(String[] args) {
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

        bfsOrlevelOrderTraversal(tree);

    }

    private static void bfsOrlevelOrderTraversal(TreeNode tree) {

        if (tree == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(tree);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }
}
