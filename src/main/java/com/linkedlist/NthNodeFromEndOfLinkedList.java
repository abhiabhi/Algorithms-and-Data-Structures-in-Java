package com.linkedlist;

import com.linkedlist.model.Node;

/**
 * Time Complexity O(n) as we are traversing the list just once.
 */

public class NthNodeFromEndOfLinkedList {

    public static void main(String args[]) {

        Node node1 = new Node(4);
        Node node2 = new Node(6);
        Node node3 = new Node(8);
        Node node4 = new Node(12);
        Node node5 = new Node(14);

        Node startNode = node1;

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(null);

        System.out.println("Loop:" + findNthNodeFromEnd(startNode, 3).getData());

    }

    private static Node findNthNodeFromEnd(Node startNode, int n) {
        Node firstPointer = startNode, secondPointer = startNode;
        int count = 1;

        /**
         * We start the firstPointer and move by one step till count is equal to Nth.
         * Once count is equal to Nth number means firstPointer standing at Nth Node,
         * then we start secondPointer and move one step each till firstPointer reaches end.
         *
         */
        while (count <= n) {
            firstPointer = firstPointer.getNext();
            count++;
        }

        /**At this point both firstPointer and secondPointer are at Nth distance from each other
         * So we start secondPointer now and increment by one till firstPointer reaches end of linked list.
         * when firstPointer reaches end means second pointer is at Nth Node from end of linked List
          */
        while (firstPointer != null) {
            firstPointer = firstPointer.getNext();
            secondPointer = secondPointer.getNext();
        }

        return secondPointer;

    }


}
