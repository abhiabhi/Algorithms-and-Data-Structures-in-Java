package com.arrays;

/**
 *
 * Complexity Analysis:
 * Time Complexity: O(n), Only one traversal of original array is needed. So the time complexity is O(n).
 *
 * Question
 * Stickler the thief wants to loot money from a society having n houses in a single line.
 * Rule 1 - never loot two consecutive houses.
 * he wants to maximize the amount he loots.
 * find the maximum money he can get if he strictly follows the rule.
 *
 */
public class MaxSumWithoutAdjacents {

    public static void main(String[] args) {

        int[] input = {3, 2, 5, 10, 7};
        int counter = 0;
        int evenSum = 0;
        int oddSum = 0;

        while (counter != input.length) {

            if (counter % 2 == 0) {
                evenSum += input[counter];
            } else {
                oddSum += input[counter];
            }
            counter++;
        }
        int max = Integer.max(evenSum, oddSum);
        System.out.println(max);
    }
}