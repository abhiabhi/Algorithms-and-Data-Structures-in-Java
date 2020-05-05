package com.tree;

import com.tree.model.TreeNode;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree
 * is now the root of the tree, and every node has no left child and only 1 right child.
 * Example 1:
 * Input: [5,3,6,2,4,null,8,1,null,null,null,7,9]
 *
 *        5
 *       / \
 *     3    6
 *    / \    \
 *   2   4    8
 *  /        / \
 * 1        7   9
 *
 * Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 *
 *  1
 *   \
 *    2
 *     \
 *      3
 *       \
 *        4
 *         \
 *          5
 *           \
 *            6
 *             \
 *              7
 *               \
 *                8
 *                 \
 *                  9
 *
 *  he definition of a binary search tree is that for every node,
 *  all the values of the left branch are less than the value at the root,
 *  and all the values of the right branch are greater than the value at the root.
 *
 * Because of this, an in-order traversal of the nodes will yield all the values in increasing order.
 *
 * Algorithm
 *
 * Once we have traversed all the nodes in increasing order,
 * we can construct new nodes using those values to form the answer.
 *
 * Complexity Analysis
 *
 * Time Complexity: O(N), where N is the number of nodes in the given tree.
 *
 * Space Complexity: O(N), the size of the answer.
 *
 */
public class IncreasingOrderSearchTree {
    public static void main (String args[]){
        TreeNode node = new TreeNode(0);
        increasingOrderSearchTree(node);
    }


    public static TreeNode increasingOrderSearchTree(TreeNode node){
        List<Integer>values = new ArrayList<>();

        /**important */
        inOrderTraversal(node, values);//values contains all the elements in increasing order.
        TreeNode ans = new TreeNode(0);
        TreeNode current = ans;

        /**important */
        for(int val : values){
            current.right = new TreeNode(val);
            current = current.right;
        }

        return current.right;

    }

    public static void inOrderTraversal(TreeNode node, List values){
        if(node == null){
            return;
        }
        inOrderTraversal(node.left,values);
        values.add(node.val);
        inOrderTraversal(node.right,values);
    }
}
