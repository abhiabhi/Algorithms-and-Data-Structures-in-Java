package com.arrays;

/**
 * An array is called Bitonic if it is comprises of an increasing sequence of integers followed immediately
 * by a decreasing sequence of integers.
 * Given a bitonic array A of N distinct integers. Find a element X in it.
 * <p>
 * You may assume no duplicate exists in the array.
 */
public class SearchInRotatedSortedArray_BitonicArray {

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = (left + right) / 2;
            if (target == nums[mid])
                return mid;

            /** update left and right
                left will always move forward and right will always shrink*/
            if (nums[left] <= nums[mid]) {  /** first half  = left -> mid */
                if (nums[left] <= target && target < nums[mid]) { /** target is between left and mid so means left at right position and need
                                                                      to update right as right will always shrink/move backward it will be mid-1 */
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {  /** second half = mid -> right */
                if (nums[mid] < target && target <= nums[right]) { /** target is between mid and right so means right is at correct position and need
                                                                        to update left as left will always move forward it will be mid+1 */
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
        System.out.println("Element found at index : " + search(arr, 7));
    }
}
