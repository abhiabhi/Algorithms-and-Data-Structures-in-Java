package com.heaps;

import java.util.PriorityQueue;


/*

Example:

int[] A = { 1, 2, 10, 20, 40, 32, 44, 51, 6 };

K=4. 4th smallest element in given array: 10

Approach: (Kth Smallest Element)
        Use min-Heap. (Click here to read about Priority Queue).
        Insert all the elements in the Priority Queue.
        Extract K elements from the priority queue.
        The last element (kth) extracted with be the kth smallest element in the array.

Link to priority Queue -
https://onedrive.live.com/redir?resid=26052E8C3C647484%21105&page=Edit&wd=target%28Queue.one%7C71d394a6-f4c4-41dd-b56a-e1878e78a88a%2FPriorityQueue%7C27bf58ff-75e1-4c3a-aa71-2823e1ff846b%2F%29


*/
public class KthSmallestElement {

    public static int findKthSmallest(int arr[], int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : arr) {
            minHeap.add(num);
        }
            int n = -1;
            while(k>0){
                 n = minHeap.poll();
                 k--;
            }

        return n;
    }

    public static void main(String args[]) {
        int arr[] = {10, 70, 20, 30, 50, 80};
        int result = findKthSmallest(arr, 5);
        System.out.println(result);
    }
}
