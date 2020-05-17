package com.arrays;

import java.util.Arrays;

/**
 * This method uses the method of Sorting and Two-pointer Technique to solve the above problem.
 * This execution will involve O(n2)) time complexity and O(1) space complexity.
 */


/**
 * 1. Sort all element of array
 * 2. Run loop from i=0 to n-2.
 * Initialize two index variables l=i+1 and r=n-1
 * 4. while (l < r)
 * Check sum of arr[i], arr[l], arr[r] is
 * given sum or not if sum is 'sum', then print
 * the triplet and do l++ and r--.
 * 5. If sum is less than given sum then l++
 * 6. If sum is greater than given sum then r--
 * 7. If not exist in array then print not found.
 */

/**
 * Complexity Analysis:
 * Time Complexity: O(n2).
 * Use of a nested loop (one for iterating , other for two-pointer technique) brings the time complexity to O(n2).
 * Auxiliary Space: O(1).
 * As no use of additional data structure is used.
 */

public class TripletSumInArray_Sorting_TwoPointerAlgo {

    public static void find_all_triplets(int[] arr, int sum) {

        /**sort array elements*/
        Arrays.sort(arr);  /**important*/

        int n = arr.length;
        int left;
        int right;
        for (int i = 0; i < n - 2; i++) {
            left = i + 1; //cursor starting from front
            right = n - 1; // cursor starting from end
            while (left < right) {
                int tempSum = arr[i] + arr[left] + arr[right];
                if (tempSum == sum) {
                    System.out.println("triplet:{" + arr[i] + "," + arr[left] + "," + arr[right] + "}");
                    left++;
                    right--;
                } else if (tempSum < sum) {
                    left++;
                } else {
                    right--;
                }
            }
        }
    }


    public static void main(String args[]) {
        int arr[] = {1, 7, 4, 3, 4, 5, 2};
        int sum = 9;
        find_all_triplets(arr, sum);
    }
}
