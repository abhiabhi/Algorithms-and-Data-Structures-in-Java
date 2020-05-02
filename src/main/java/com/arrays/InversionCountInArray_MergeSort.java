package com.arrays;

import java.util.Arrays;

/**
 * Inversion Count : For an array, inversion count indicates how far (or close) the array is from being sorted.
 * If array is already sorted then inversion count is 0. If array is sorted in reverse order that inversion count is the maximum.
 * Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
 * <p>
 * <p>
 * Algorithm:
 * The idea is similar to merge sort, divide the array into two equal or almost equal halves in each step until the base case is reached.
 * Create a function merge that counts the number of inversions when two halves of the array are merged,
 * create two indices i and j, i is the index for first half and j is an index of the second half.
 * if a[i] is greater than a[j], then there are (mid – i) inversions. because left and right subarrays are sorted, so all the remaining elements in left-subarray (a[i+1], a[i+2] … a[mid]) will be greater than a[j].
 * Create a recursive function to divide the array into halves and find the answer by summing the number of inversions is the first half, number of inversion in the second half and the number of inversions by merging the two.
 * The base case of recursion is when there is only one element in the given half.
 * Print the answer
 * <p>
 * <p>
 * Complexity Analysis:
 * Time Complexity: O(n log n), The algorithm used is divide and conquer, So in each level one full array traversal is needed and there are log n levels so the time complexity is O(n log n).
 * Space Compelxity:O(1), No extra space is required.
 */
public class InversionCountInArray_MergeSort {

    // Merge two sorted subarrays arr[low .. mid] and arr[mid + 1 .. high]
    public static int merge(int[] arr, int leftIndex, int midIndex, int rightIndex) {
        // Left subarray
        int[] left = Arrays.copyOfRange(arr, leftIndex, midIndex + 1);

        // Right subarray
        int[] right = Arrays.copyOfRange(arr, midIndex + 1, rightIndex + 1);

        int leftCursor = 0, rightCursor = 0, current = leftIndex, swaps = 0;

        while (leftCursor < left.length && rightCursor < right.length) {
            if (left[leftCursor] <= right[rightCursor])
                arr[current++] = left[leftCursor++];
            else {
                arr[current++] = right[rightCursor++];
                swaps += (midIndex + 1) - (leftIndex + leftCursor);  /**important*/
            }
        }

        // Fill from the rest of the left subarray
        while (leftCursor < left.length)
            arr[current++] = left[leftCursor++];

        // Fill from the rest of the right subarray
        while (rightCursor < right.length)
            arr[current++] = right[rightCursor++];

        return swaps;
    }

    // Sort array arr [low..high] using auxiliary array aux[]
    public static int mergeSort(int[] arr, int low, int high) {
        // Base case
        if (high == low) {    // if run size == 1
            return 0;
        }

        // find mid point
        int mid = (low + high) / 2;
        int inversionCount = 0;

        // recursively split runs into two halves until run size == 1,
        // then merge them and return back up the call chain

        inversionCount += mergeSort(arr, low, mid);        // split / merge left half
        inversionCount += mergeSort(arr, mid + 1, high); // split / merge right half
        inversionCount += merge(arr, low, mid, high);    // merge the two half runs

        return inversionCount;
    }

    public static void main(String[] args) {
        int[] arr = {1, 9, 6, 4, 5};
        int[] aux = Arrays.copyOf(arr, arr.length);

        // get inversion count by performing merge sort on arr
        System.out.println("Inversion count is " +
                mergeSort(arr, 0, arr.length - 1));
    }
}
