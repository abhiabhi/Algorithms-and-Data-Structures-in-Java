package com.tree;

import com.tree.model.TreeNode;

/**
 * Complexity Analysis
 *
 * Time complexity : O(n)O(n). We traverse over a total of nn nodes. Here, nn refers to the smaller of the number of nodes in the two trees.
 *
 * Space complexity : O(n)O(n). The depth of stack can grow upto nn in case of a skewed tree.
 */

public class MergeTwoBinaryTrees {

    public static void main (String args[]) {
        TreeNode tree1 = new TreeNode(100);
        tree1.left = new TreeNode(50);
        tree1.right = new TreeNode(150);
        tree1.left.left = new TreeNode(25);
        tree1.left.right = new TreeNode(55);
        tree1.right.left = new TreeNode(125);
        tree1.right.right = new TreeNode(165);

        TreeNode tree2 = new TreeNode(1000);
        tree2.left = new TreeNode(500);
        tree2.right = new TreeNode(1500);
        tree2.left.left = new TreeNode(250);
        tree2.left.right = new TreeNode(550);
        tree2.right.left = new TreeNode(1250);
        tree2.right.right = new TreeNode(1650);

        mergeTrees(tree1, tree2);
    }

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        /**Base conditions*/
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;

        /**construct treeNode here*/
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);

        return t1;
    }
}
