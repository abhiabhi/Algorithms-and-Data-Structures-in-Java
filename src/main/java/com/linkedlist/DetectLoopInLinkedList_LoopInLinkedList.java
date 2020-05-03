package com.linkedlist;

import com.linkedlist.model.Node;

public class DetectLoopInLinkedList_LoopInLinkedList {

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
        node5.setNext(node2);

        System.out.println("Loop:" + detectLoop(startNode));

    }

    private static boolean detectLoop(Node startNode) {
        Node slowPointer = startNode; // Initially ptr1 is at starting location.
        Node fastPointer = startNode; // Initially ptr2 is at starting location.

        while (fastPointer != null && fastPointer.getNext() != null) { // If ptr2 encounters NULL, it means there is no Loop in Linked list.
            slowPointer = slowPointer.getNext(); // ptr1 moving one node at at time
            fastPointer = fastPointer.getNext().getNext(); // ptr2 moving two nodes at at time

            if (slowPointer == fastPointer) // if ptr1 and ptr2 meets, it means linked list contains loop.
                return true;
        }
        return false;
    }

}
