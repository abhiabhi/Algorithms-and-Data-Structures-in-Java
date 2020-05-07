package com.heaps;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Median is the middle value in an ordered integer list.
 * If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
 * <p>
 * First of all, it seems that the best time complexity we can get for this problem is O(log(n)) of add() and O(1) of getMedian().
 * This data structure seems highly likely to be a tree.
 * O(log(n)) of add() and O(1) of getMedian()
 */
class FindMedianFromDataStream {

    PriorityQueue<Integer> minHeap = null;
    PriorityQueue<Integer> maxHeap = null;

    /**
     * initialize your data structure here.
     */
    public FindMedianFromDataStream() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public void addNum(int num) {
        minHeap.offer(num); /** Step 1- Each element is first added to minHeap First */
        maxHeap.offer(minHeap.poll()); /** Step 2- Minimum element is poped put and offered to MaxHeap .
                                           This assures all the elements in minHeap are greater than maxHeap */

        if (minHeap.size() < maxHeap.size()) {  /** Step 3- The two heaps need to be laod balanced */
            minHeap.offer(maxHeap.poll());
        }
    }

    public double findMedian() {
        if (minHeap.size() > maxHeap.size()) {  /** Odd num of total elements */
            return minHeap.peek();
        } else {
            return (minHeap.peek() + maxHeap.peek()) / 2.0; /** Even  num of total elements */
        }
    }

    public static void main(String[] args) {
        FindMedianFromDataStream stream = new FindMedianFromDataStream();

        stream.addNum(2);
        stream.addNum(5);
        stream.addNum(8);
        stream.addNum(18);
        stream.addNum(20);
        stream.addNum(28);

        System.out.println("Median " + stream.findMedian());
    }
}

