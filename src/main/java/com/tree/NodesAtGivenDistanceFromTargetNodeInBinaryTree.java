package com.tree;

import com.tree.model.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NodesAtGivenDistanceFromTargetNodeInBinaryTree {

    // Function to check if given TreeNode is a leaf TreeNode or not
    public static boolean isLeaf(TreeNode TreeNode) {
        return (TreeNode.left == null && TreeNode.right == null);
    }

    // Recursive function to find all TreeNodes at given distance from leaf TreeNodes
    public static void leafTreeNodeDistance(TreeNode TreeNode, List<TreeNode> path,
                                            Set<TreeNode> set, int dist) {
        // base case: empty tree
        if (TreeNode == null) {
            return;
        }

        // if a leaf TreeNode is found, insert the TreeNode at distance 'dist' from
        // leaf TreeNode into the set
        if (isLeaf(TreeNode) && path.size() >= dist) {
            set.add(path.get(path.size() - dist));
            return;
        }

        // include current TreeNode into current path
        path.add(TreeNode);

        // recur for left and right subtree
        leafTreeNodeDistance(TreeNode.left, path, set, dist);
        leafTreeNodeDistance(TreeNode.right, path, set, dist);

        // remove current TreeNode from the current path
        path.remove(TreeNode);
    }

    // find all distinct TreeNodes at given distance from leaf TreeNodes
    public static void leafTreeNodeDistance(TreeNode TreeNode, int dist) {
        // list to store root to leaf path
        List<TreeNode> path = new ArrayList<>();

        // create an empty set to store distinct TreeNodes at given
        // distance from leaf TreeNodes
        Set<TreeNode> set = new HashSet<>();

        // find all TreeNodes
        leafTreeNodeDistance(TreeNode, path, set, dist);

        // print output
        for (TreeNode e : set) {
            System.out.print(e.val + " ");
        }
    }

    // main function
    public static void main(String[] args) {
		/* Construct below tree
		          15
		        /    \
		       /      \
		      10       20
		     / \      /  \
		    8   12   16  25
		            /
		           18
		*/

        TreeNode root = new TreeNode(15);
        root.left = new TreeNode(10);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(12);
        root.right.left = new TreeNode(16);
        root.right.right = new TreeNode(25);
        root.right.left.left = new TreeNode(18);

        int dist = 1;
        leafTreeNodeDistance(root, dist);
    }
}