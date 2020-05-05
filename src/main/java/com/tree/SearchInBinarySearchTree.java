package com.tree;

import com.tree.model.TreeNode;

public class SearchInBinarySearchTree {

    public static TreeNode searchInBST(TreeNode node, int val){
        if (node == null){
            return null;
        }

        if (node.val == val){
            return node;
        }

        if (val < node.val){
            return searchInBST(node.left, val);
        }else{
           return searchInBST(node.right, val);
        }

    }
}
