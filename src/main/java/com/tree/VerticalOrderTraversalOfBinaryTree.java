package com.tree;

import com.tree.model.TreeNode;

import java.util.TreeMap;

/**
 *
 * Horizontal Distance for Root = 0
 * Left child = HD (parent) -1
 * Right child = HD (parent) +1
 *
 * If two nodes have the same Horizontal Distance from root, then they are on same vertical line.
 *
 * Algorithm
 * 1. Read the tree in Pre-order traversal
 *
 * 2. First node encounter will be root node, which is at hd 0 as this is starting point in scale. (hd is 0)
 *
 * 3. From this point,
 *     When we will move on Left, that is we are moving one column on left side, we will do (hd-1),
 *     When we will move on Right, that is we are moving one column on right side, we will do (hd+1).
 *
 * 4. We will take one map, which will keep dumping all the nodes found at same horizontal distance
 *     from root. (for map, key is hd and value will be nodes found).
 *
 *     For each node encountered, check whether distance is already present in map,
 *          If it is present then we already encountered nodes at same distance prior to this node,
 *          So append current node data to existing nodes.
 *
 *          If it is not present then this is the first time we are encountering this distance,
 *          so simply store the data against hd.
 *
 * 5. Better to use TreeMap in this case, as it will store the result in ascending order,
 *     which we are interested in.
 *
 * 6. Print map.
 *
 */
public class VerticalOrderTraversalOfBinaryTree {
    public static void main(String args[]) {

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
        tree.right.left = new TreeNode(7);
        tree.right.right = new TreeNode(8);
        tree.left.left.left = new TreeNode(10);

        /**Better to use TreeMap in this case, as it will store the result in ascending order of keys i.e
         * horizontal distance*/
        TreeMap<Integer, String> map= new TreeMap();
        printInVerticalOrder(tree, map, 0);

        for(Integer key : map.keySet()){
            System.out.print(map.get(key) + " ");
        }
    }

    private static void printInVerticalOrder(TreeNode root, TreeMap<Integer,String> map, int horizontalDistance) {

        if(root == null){
            return;
        }

       if(map.get(horizontalDistance)!=null){
           map.put(horizontalDistance, map.get(horizontalDistance)+","+root.val);
       }else{
           map.put(horizontalDistance, String.valueOf(root.val));
       }

       printInVerticalOrder(root.left, map,horizontalDistance-1);
       printInVerticalOrder(root.right, map,horizontalDistance+1);

    }
}
