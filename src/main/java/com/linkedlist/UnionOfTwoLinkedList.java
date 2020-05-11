package com.linkedlist;

import com.linkedlist.model.Node;

import java.util.HashMap;

/**
 * Input:
 *    List1: 10->15->4->20
 *    lsit2:  8->4->2->10
 * Output:
 *    Intersection List: 4->10
 *    Union List: 2->8->20->4->15->10
 */
public class UnionOfTwoLinkedList {
    Node getUnion(Node head1, Node head2)
    {
        // HashMap that will store the  
        // elements of the lists with their counts 
        HashMap<Integer, Integer> hmap = new HashMap<>();
        Node n1 = head1;
        Node n2 = head2;
        Node result = null;

        // loop inserts the elements and the count of  
        // that element of list1 into the hmap 
        while(n1 != null)
        {
            if(hmap.containsKey(n1.data))
            {
                int val = hmap.get(n1.data);
                hmap.put(n1.data, val + 1);
            }
            else
            {
                hmap.put(n1.data, 1);
            }
            n1 = n1.next;
        }

        // loop further adds the elements of list2 with  
        // their counts into the hmap  
        while(n2 != null)
        {
            if(hmap.containsKey(n2.data))
            {
                int val = hmap.get(n2.data);
                hmap.put(n2.data, val + 1);
            }
            else
            {
                hmap.put(n2.data, 1);
            }
            n2 = n2.next;
        }

        // Eventually add all the elements 
        // into the result that are present in the hmap
        result = new Node(0);

        for(int a:hmap.keySet())
        {
            result.setNext(new Node(a));
        }
        return result;
    }

    /* Driver program to test above functions */

} 

