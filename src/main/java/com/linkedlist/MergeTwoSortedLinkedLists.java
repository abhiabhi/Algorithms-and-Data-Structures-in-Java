package com.linkedlist;

import com.linkedlist.model.Node;

/**
 * Time complexity : O ( k N ) O(kN) O(kN) where k is the number of linked lists.
 * We can merge two sorted linked list in O ( n ) O(n) O(n) time where n is the total number of nodes in two lists
 */
public class MergeTwoSortedLinkedLists {

    public static void main (String args[]){
        Node node1 = new Node(4);
        Node node2 = new Node(6);
        Node node3 = new Node(8);
        Node node4 = new Node(12);
        Node node5 = new Node(14);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(null);

        Node list1 = node1;

        Node node11 = new Node(41);
        Node node21 = new Node(61);
        Node node31 = new Node(81);
        Node node41 = new Node(121);
        Node node51 = new Node(141);

        node11.setNext(node21);
        node21.setNext(node31);
        node31.setNext(node41);
        node41.setNext(node51);
        node51.setNext(null);

        Node list2 = node11;

        mergeSortedList(list1, list2);
        printList( mergeSortedList(list1, list2));

    }

    private static void printList(Node mergeSortedList) {
        while(mergeSortedList!= null) {
            System.out.println(mergeSortedList.getData());
            mergeSortedList = mergeSortedList.getNext();
        }

    }

    private static Node mergeSortedList(Node list1, Node list2) {

            if(list1 == null) return list2;
            if(list2 == null) return list1;

            Node result ;

            if(list1.getData() < list2.getData())
            {
                result = new Node(list1.getData());
                result.setNext(mergeSortedList(list1.getNext(), list2));
            }
            else
            {
                result = new Node(list2.getData());
                result.setNext(mergeSortedList(list1, list2.getNext()));
            }

            return result;

        }


    }

