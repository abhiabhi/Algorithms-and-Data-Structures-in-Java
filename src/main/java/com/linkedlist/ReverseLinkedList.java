package com.linkedlist;

import com.linkedlist.model.Node;

/**
 * For Reversing a linked list we update
 * the pointer of each node to point to previous node instead of next node
 */
public class ReverseLinkedList {

    public static void main(String args[]) {
        Node targetList = new Node(4);
        targetList.setNext(new Node(8));
        targetList.getNext().setNext(new Node(10));
        targetList.getNext().getNext().setNext(new Node(12));

        Node headOfReverseList = reverseLinkedList(targetList);

        while (headOfReverseList != null) {
            System.out.println(headOfReverseList.getData());
            headOfReverseList = headOfReverseList.getNext();
        }

    }

    private static Node reverseLinkedList(Node head) {
        /** Initialize 3 pointers */
        Node previous = null;
        Node current = head;
        Node next = null;

        while (current != null) {

            next = current.getNext(); /**save next */
            current.setNext(previous); /** reverse */

            /** Advance prev and current */
            previous = current;
            current = next;
        }

        return previous; /** return ne head at the end */

    }
}
