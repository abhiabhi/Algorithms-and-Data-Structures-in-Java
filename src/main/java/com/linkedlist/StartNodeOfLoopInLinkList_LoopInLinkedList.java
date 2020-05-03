package com.linkedlist;

import com.linkedlist.model.Node;

public class StartNodeOfLoopInLinkList_LoopInLinkedList {

    Node startNode;

    public static void main(String[] args) {

        StartNodeOfLoopInLinkList_LoopInLinkedList g = new StartNodeOfLoopInLinkList_LoopInLinkedList();

        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(30);
        Node n4 = new Node(40);
        Node n5 = new Node(50);
        Node n6 = new Node(60);
        Node n7 = new Node(70);
        Node n8 = new Node(80);

        g.startNode = n1;

        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        n5.setNext(n6);
        n6.setNext(n7);
        n7.setNext(n8);
        n8.setNext(n6);

        Node loopNode = g.getStartNodeOfLoopInLinklist(g.startNode);

        if (loopNode == null) {
            System.out.println("Loop not present");
        } else {
            System.out.println("Start node of Loop is :" + loopNode.getData());
        }
    }

    private Node getStartNodeOfLoopInLinklist(Node startNode) {
        Node slowPointer = startNode; // Initially ptr1 is at starting location.
        Node fastPointer = startNode; // Initially ptr2 is at starting location.

        // If ptr2 encounters NULL, it means there is no Loop in Linked list.
        while (fastPointer != null && fastPointer.getNext() != null) {
            slowPointer = slowPointer.getNext(); // ptr1 moving one node at at time
            fastPointer = fastPointer.getNext().getNext(); // ptr2 moving two nodes at at time

            // if ptr1 and ptr2 meets, it means linked list contains loop.
            if (slowPointer == fastPointer) {

                //After meet, moving slowPointer to start node of list.
                slowPointer = startNode;

                //Moving slowPointer and fastPointer one node at a time till the time they meet at common point.
                while (slowPointer != fastPointer) {
                    slowPointer = slowPointer.getNext();
                    fastPointer = fastPointer.getNext();
                }

                //returning start node of loop.
                return slowPointer;

            }
        }

        // this condition will arise when there is no loop in list.
        return null;
    }
}

