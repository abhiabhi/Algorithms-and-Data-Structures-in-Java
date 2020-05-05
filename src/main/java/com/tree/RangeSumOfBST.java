package com.tree;

import com.tree.model.TreeNode;

/**
 * Complexity Analysis
 * <p>
 * Time Complexity: O(N)O(N), where NN is the number of nodes in the tree.
 * <p>
 * Space Complexity: O(H)O(H), where HH is the height of the tree.
 *
 * Approach 1: Depth First Search
 * Intuition and Algorithm
 *
 * We traverse the tree using a depth first search.
 * If node.val falls outside the range [L, R], (for example node.val < L),
 * then we know that only the right branch could have nodes with value inside [L, R].
 *
 */
public class RangeSumOfBST {
    static int ans = 0;

    public static void main(String args[]) {
        TreeNode tree = new TreeNode(50);
        tree.left = new TreeNode(40);
        tree.right = new TreeNode(60);
        tree.left.left = new TreeNode(30);
        tree.left.right = new TreeNode(45);
        tree.right.left = new TreeNode(56);
        tree.right.right = new TreeNode(65);
        tree.left.left.left = new TreeNode(20);
        calculateRangeSum(tree, 20, 40);
        System.out.println("SUM : " + ans);
    }

    private static void calculateRangeSum(TreeNode tree, int min, int max) {

        if (tree != null) {

            if (tree.val >= min && tree.val <= max) {
                ans += tree.val;
            }

            if (tree.val > min) {
                calculateRangeSum(tree.left, min, max);
            }
            if (tree.val < max) {
                calculateRangeSum(tree.right, min, max);
            }
        }
    }
}
