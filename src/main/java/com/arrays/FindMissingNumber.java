package com.arrays;

import java.time.Duration;
import java.time.Instant;

/**
 * Input: arr[] = {1, 2, 4, 6, 3, 7, 8}
 * Output: 5
 * Explanation: The missing number from 1 to 8 is 5
 * <p>
 * Input: arr[] = {1, 2, 3, 5}
 * Output: 4
 * Explanation: The missing number from 1 to 5 is 4
 * <p>
 * Approach:
 * XOR has certain properties
 * Assume a1 ^ a2 ^ a3 ^ …^ an = a and a1 ^ a2 ^ a3 ^ …^ an-1 = b
 * Then a ^ b = an
 * Using this property, the missing element can be found. Calculate XOR of all the natural number from 1 to n and store it as a.
 * Now calculate XOR of all the elements of the array and store it as b.
 * The missing number will be a ^ b.
 * ^ is XOR operator.
 * <p>
 * Algorithm:
 * Create two variables a = 0 and b = 0
 * Run a loop from 1 to n with i as counter.
 * For every index update a as a = a ^ i
 * Now traverse the array from start to end.
 * For every index update b as b = b ^ array[i]
 * Print the missing number as a ^ b.
 * <p>
 * Compelxity Analysis:
 * Time Complexity: O(n).
 * Only one traversal of array is needed.
 * Space Complexity: O(1).
 * No extra space is needed
 * <p>
 * Bitwise operations are incredibly simple and thus usually faster than arithmetic operations.
 */

public class FindMissingNumber {

    public static long missingNumber(int[] nums, int n) {
        System.out.println("time start");

        long naturalNumberXOR = 1;
        long arrayXOR = nums[0];

        for (int i = 2; i <= n + 1; i++) {
            naturalNumberXOR = naturalNumberXOR ^ i;
        }

        for (int i = 1; i < nums.length; i++) {
            arrayXOR = arrayXOR ^ nums[i];
        }
        System.out.println("time end");
        return naturalNumberXOR ^ arrayXOR;


    }


    public static long missingNumberUsingSUm(int[] nums, int n) {
        System.out.println("time start");
        long naturalNumberSum = 1;
        long arraySum = nums[0];

        naturalNumberSum = (n * (n + 1)) / 2;  //Summation formula GUass's formula


        for (int i = 1; i < nums.length; i++) {
            arraySum = arraySum + nums[i];
        }
        System.out.println("time end");
        return naturalNumberSum - arraySum;

    }

    public static void main(String args[]) {
        int[] nums = {1, 2, 3, 4, 5, 7, 8, 9, 10};
        System.out.println("Missing Number:" + missingNumberUsingSUm(nums, 10));
    }
}
