package com.tree;

import com.tree.model.TreeNode;

public class LargestNumberInBSTWhichIsLessThanOrEqualToN {

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

        System.out.println("MaxValueLessThanN : " + findMaxValueLessThanN(tree,7));
    }

    //Iterative Solution
    public static int findMaxValueLessThanN(TreeNode root, int n) {
        int val = -1;
        while(root != null) {
            if(root.val > n) {
                //When you go towards left of root node, it means current value is greater than N,
                //No need to take backup as current node is > N and you need value less than N.
                //Note: when you move towards right that is the only case your current node is lower than N and
                //you are searching for higher node and we are already taking backup at that time.
                root = root.left;
            } else {
                //When you go towards right of root node, it means you will be moving towards higher value compared to current one,
                //Take the backup of current one as that may be second highest.
                val = root.val;
                root = root.right;
            }
        }
        return val;
    }

}
