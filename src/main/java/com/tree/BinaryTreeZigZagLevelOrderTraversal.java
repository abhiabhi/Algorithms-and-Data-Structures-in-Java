package com.tree;

import com.tree.model.TreeNode;

import java.util.*;

/**
 * Description:
 * Given a binary tree, return the zigzag level order traversal of its TreeNodes' values. (ie, from left to right, then
 * right to left for the next level and alternate between).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * Algorithm
 * 1.  Take 2 Stack, one for current level and one for next level.
 *
 *
 * 2.  For filling the next Level stack, we have to see whether it need to be filled Left to Right or Right
 *      to left as we are reading the Level Order spirally.
 * 3.  When we are reading current level stack, all the children's of current level stack will go to next
 *      level stack.
 * 4.  When current level stack has no value and is Empty at that time point current level stack
 *      reference to hold next level stack values, that is current level stack will now point to next level
 *      stack and next level stack should be reinitialize for its next level.
 *      Also, this is the time when we need to alter our reading style for childrens that is it need to be
 *      read in left - right fashion.
 *
 */

public class BinaryTreeZigZagLevelOrderTraversal {

    /**
     * Time Complexity:
     * Space Complexity:
     * Runtime: <a href="https://leetcode.com/submissions/detail/250830618/">1 ms</a>.
     *
     * @param rootTreeNode
     * @return
     */
    public static void zigZagTraverse(TreeNode rootTreeNode) {

            // Base case
            if(rootTreeNode==null){
                return;
            }

            Stack<TreeNode> currentLevelStack = new Stack<TreeNode>();
            Stack<TreeNode> nextLevelStack = new Stack<TreeNode>();

            boolean isLeftRightReading = true;
            currentLevelStack.add(rootTreeNode);

            while(!currentLevelStack.isEmpty()){
                TreeNode n = currentLevelStack.pop();
                System.out.print(n.val+ " ");

                if(isLeftRightReading){

                    if(n.left!=null)
                        nextLevelStack.push(n.left);

                    if(n.right!=null)
                        nextLevelStack.push(n.right);

                }else{
                    if(n.right!=null)
                        nextLevelStack.push(n.right);

                    if(n.left!=null)
                        nextLevelStack.push(n.left);

                }

                if(currentLevelStack.isEmpty()){
                    isLeftRightReading = !isLeftRightReading;
                    currentLevelStack=nextLevelStack;
                    nextLevelStack = new Stack<TreeNode>();
                }

            }
        }


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

        zigZagTraverse(tree);

    }
}


