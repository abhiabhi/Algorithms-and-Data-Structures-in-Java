package com.linkedlist;

import com.linkedlist.model.DoublyLLNode;

import java.util.HashMap;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache, which supports get and put.
 * The key to solve this problem is using a double linked list which enables us to quickly move nodes.
 *
 * The LRU cache is a hash table of keys and double linked nodes.
 * The hash table makes the time of get() to be O(1). The list of double linked nodes make the nodes adding/removal operations O(1).
 *
 * By analyzing the get and put, we can summarize there are 2 basic operations:
 * 1) removeNode(Node t), 2) offerNode(Node t).
 *
 */
class LRUCache {
    DoublyLLNode head;
    DoublyLLNode tail;
    HashMap<Integer, DoublyLLNode> map = null;
    int cap = 0;

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.map = new HashMap<>();
    }

    public int get(int key) {
        if(map.get(key)==null){
            return -1;
        }

        //move to tail
        DoublyLLNode t = map.get(key);

        removeDoublyLLNode(t);
        offerDoublyLLNode(t);

        return t.value;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            DoublyLLNode t = map.get(key);
            t.value = value;

            //move to tail
            removeDoublyLLNode(t);
            offerDoublyLLNode(t);
        }else{
            if(map.size()>=cap){
                //delete head
                map.remove(head.key);
                removeDoublyLLNode(head);
            }

            //add to tail
            DoublyLLNode DoublyLLNode = new DoublyLLNode(key, value);
            offerDoublyLLNode(DoublyLLNode);
            map.put(key, DoublyLLNode);
        }
    }

    private void removeDoublyLLNode(DoublyLLNode n){
        if(n.prev!=null){
            n.prev.next = n.next;
        }else{
            head = n.next;
        }

        if(n.next!=null){
            n.next.prev = n.prev;
        }else{
            tail = n.prev;
        }
    }

    private void offerDoublyLLNode(DoublyLLNode n){
        if(tail!=null){
            tail.next = n;
        }

        n.prev = tail;
        n.next = null;
        tail = n;

        if(head == null){
            head = tail;
        }
    }
}