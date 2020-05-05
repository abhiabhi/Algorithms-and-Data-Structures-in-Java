package com.tree;

import com.tree.model.TreeNode;

/**
 *
 * Efficient Approach:
 *
 * Traverse BST 1 from smallest value to node to largest by taking index i. This can be achieved with the help of inorder traversal and storing value in arr
 * Traverse BST 2 from largest value node to smallest by taking index j. This can be achieved with the help of inorder traversal.
 * Perform these two traversals one by one and store into two array.
 * Sum up the corresponding node’s value from both the BSTs at a particular instance of traversals.
 * If sum > x, then print pair and decrement j by 1.
 * If x > sum, then increment i by 1.
 * Perform these operations until either of the two traversals gets completed.
 *
 */

public class TwoNodesOfTwoBSTEqualToGivenSum {

    public static void main (String args[]){
        TreeNode tree1 = new TreeNode(100);
        tree1.left = new TreeNode(50);
        tree1.right = new TreeNode(150);
        tree1.left.left = new TreeNode(25);
        tree1.left.right = new TreeNode(55);
        tree1.right.left =  new TreeNode(125);
        tree1.right.right = new TreeNode(165);

        TreeNode tree2 = new TreeNode(1000);
        tree2.left = new TreeNode(500);
        tree2.right = new TreeNode(1500);
        tree2.left.left = new TreeNode(250);
        tree2.left.right = new TreeNode(550);
        tree2.right.left =  new TreeNode(1250);
        tree2.right.right = new TreeNode(1650);

        int sum = 300;
        findPairsInTwoBSTSumIsEqualToGivenSum(tree1,tree2,sum);

    }

    private static void findPairsInTwoBSTSumIsEqualToGivenSum(TreeNode tree1, TreeNode tree2, int sum) {
        int arr1[] = new int[10];
        inorderTraversal(tree1, arr1, 0);

        int arr2[] = new int[10];
        inorderTraversal(tree2, arr2, 0);

        int arr1Index = 0;
        int arr2Index = arr2.length-1;
        int count = 0;

        while (arr1Index < arr1.length-1 && arr2Index > 0)
        {
            if(arr1[arr1Index] + arr2[arr2Index] == sum){
                count= count+1;
            }

            if(arr1[arr1Index]+arr2[arr2Index] < sum){
                arr1Index = arr1Index +1 ;
            }else{
                arr2Index = arr2Index -1;
            }

        }

        System.out.println("Count - " + count);

    }

    public static void  inorderTraversal(TreeNode tree, int[]arr, int i){

        if(tree == null){
            return;
        }

        inorderTraversal(tree.left,arr,i);
        arr[i++] =  tree.val;
        inorderTraversal(tree.right,arr,i);

    }

}
