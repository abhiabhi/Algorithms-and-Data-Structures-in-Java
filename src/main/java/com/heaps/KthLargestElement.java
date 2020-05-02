package com.heaps;

import java.util.PriorityQueue;

/**

Link to priority Queue -
https://onedrive.live.com/redir?resid=26052E8C3C647484%21105&page=Edit&wd=target%28Queue.one%7C71d394a6-f4c4-41dd-b56a-e1878e78a88a%2FPriorityQueue%7C27bf58ff-75e1-4c3a-aa71-2823e1ff846b%2F%29&wdorigin=703

An Efficient Solution is to use Min Heap of size k to store k largest elements of the stream.
The k’th largest element is always at root and can be found in O(1) time.

Time complexity of finding the k’th largest element is O(Logk).

 */
public class KthLargestElement {

    public static int findKthLargest(int arr[], int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : arr) {
            minHeap.add(num);
            if (minHeap.size() > k) {

                //this will remove the element from root since its minHeap it will remove minimum element.
                //this will rearrange the elements back in proper heap with min element on root.
                minHeap.remove();
            }
        }
        return minHeap.remove();
    }

    public static void main(String args[]) {
        int arr[] = {10, 70, 20, 30, 50, 80};
        int result = findKthLargest(arr, 2);
        System.out.println(result);
    }
}
