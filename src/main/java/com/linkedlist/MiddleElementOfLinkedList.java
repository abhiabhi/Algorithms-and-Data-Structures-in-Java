package com.linkedlist;

import com.linkedlist.model.Node;

public class MiddleElementOfLinkedList {

    public static void main(String[] args) {
        new MiddleElementOfLinkedList();
    }

    public MiddleElementOfLinkedList() {
        Node startNode = new Node(10);
        Node temp2 = new Node(20);
        Node temp3 = new Node(30);
        Node temp4 = new Node(40);
        Node temp5 = new Node(50);
        Node temp6 = new Node(60);
        Node temp7 = new Node(70);
        Node temp8 = new Node(80);

        startNode.setNext(temp2);
        temp2.setNext(temp3);
        temp3.setNext(temp4);
        temp4.setNext(temp5);
        temp5.setNext(temp6);
        temp6.setNext(temp7);
        temp7.setNext(temp8);

        Node temp = findMiddleNodeOfLinkedList(startNode);
        System.out.println(temp.getData());
    }

    private Node findMiddleNodeOfLinkedList(Node startNode) {
        if(startNode==null){
            return startNode;
        }

        Node slowPointer = startNode;
        Node fastPointer = startNode;

        /** important */
        while(fastPointer!=null && fastPointer.getNext()!=null && fastPointer.getNext().getNext()!=null){
            slowPointer = slowPointer.getNext();
            fastPointer = fastPointer.getNext().getNext();

        }
        return slowPointer;
    }

}
