package com.tree;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};


public class Nary_TreePreorderTraversal {

    public static void main(String args[]) {
        List<Node> list = new ArrayList<>();
        Node tree = new Node();
        preOrderTraversal(tree, list);
        for(Node n : list){
            System.out.println(n.val);
        }

    }

    public static void preOrderTraversal(Node tree, List list){

        if (tree==null){
            return;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(tree);

        while(!stack .isEmpty()){

            Node node = stack.pop();
            list.add(node);

            for(Node child :node.children){
              stack.push(child);
            }

        }

    }

}





