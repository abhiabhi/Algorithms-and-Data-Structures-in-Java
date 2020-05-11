package com.arrays;

import java.util.HashSet;

/**
 * Given an unsorted array of integers,
 * find the length of the longest consecutive elements sequence.
 *
 * For example, given [100, 4, 200, 1, 3, 2],
 * the longest consecutive elements sequence should be [1, 2, 3, 4]. Its length is 4.
 *
 * Because it requires O(n) complexity,
 * we can not solve the problem by sorting the array first. Sorting takes at least O(nlogn) time.
 *
 * We can use a HashSet to add and remove elements.
 * The add, remove and contains methods have constant time complexity O(1).
 */
public class LongestConsecutiveSubsequence {

    public static int longestConsecutive(int[] nums) {

        /** Add all the elements of array to Set */
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums)
            set.add(num);

        int result = 0;

        /** Iterate over each element in array */
        for (int num : nums) {
            int count = 1;

            /** calculate previous element to current element to see if present in set */
            int down = num - 1;
            while (set.contains(down)) {
                set.remove(down);
                down--;
                count++;
            }

            /** calculate next element to current element to see if present in set */
            int up = num + 1;
            while (set.contains(up)) {
                set.remove(up);
                up++;
                count++;
            }

            /** update the result if current counter is bigger than result */
            result = Math.max(result, count);
        }

        return result;
    }

    public static void main(String args[]) {
        int nums[] = {1, 5, 4, 100, 200, 2, 3};
        int result = longestConsecutive(nums);
        System.out.println("longestConsecutive : " + result);
    }
}
