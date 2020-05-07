package com.arrays;

/**
 * An array is called Bitonic if it is comprises of an increasing sequence of integers followed immediately
 * by a decreasing sequence of integers.
 * Given a bitonic array A of N distinct integers. Find a element X in it.
 */
public class SearchInRotatedSortedArray_BitonicArray {

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;
            if (target == nums[mid])
                return mid;

            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            if (nums[mid] <= nums[right]) {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String args[]) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Element found at index : " + search(arr, 6));
    }
}
