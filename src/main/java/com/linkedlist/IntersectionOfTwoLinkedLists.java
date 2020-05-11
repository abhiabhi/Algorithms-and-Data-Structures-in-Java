package com.linkedlist;

import com.linkedlist.model.Node;

import java.util.HashSet;
import java.util.Set;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 *
 * For example, the following two linked lists:
 *
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * Output: Reference of the node with value = 8
 * Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
 * From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,0,1,8,4,5].
 * There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
 *
 * Notes
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 *
 */
public class IntersectionOfTwoLinkedLists {

    //Approach 2: Hash Table (10ms)
    public Node getIntersectionNode(Node headA, Node headB) {
        Set<Node> nodes = new HashSet<>();
        Node pa = headA;
        while (pa != null) {
            nodes.add(pa);
            pa = pa.next;
        }
        if (nodes.isEmpty()) {
            return null;
        }
        Node pb = headB;
        while (pb != null) {
            if (nodes.contains(pb)) {
                return pb;
            }
            pb = pb.next;
        }
        return null;
    }

    //Approach 3: Two Pointers (1ms)

    public Node getIntersectionNode_1(Node headA, Node headB) {
        Node pa = headA, pb = headB;
        while (pa != pb) {
            pa = (pa != null) ? pa.next : headB;
            pb = (pb != null) ? pb.next : headA;
        }
        return pa;
    }


}



