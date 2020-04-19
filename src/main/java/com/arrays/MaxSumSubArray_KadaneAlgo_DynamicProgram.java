package com.arrays;
/*

Dynamic programming solves a problem by dividing it into smaller subproblems. This is very similar to the divide-and-conquer algorithm solving technique.
 The major difference, however, is that dynamic programming solves a subproblem only once.
It then stores the result of this subproblem and later reuses this result to solve other related subproblems. This process is known as memoization.

Dynamic programming builds solutions from the bottom up by breaking each problem down into smaller,
problems that you solve first. Recursion also breaks problems down into subproblems but does this from
the top down.
One advantage of dynamic programming over recursion is that it prevents possible duplicate solutions of the same subproblem,
which uses less CPUs and generally makes your code run faster.

Complexity of finding largest sum subarray in an array is O(N) in time and O(1) in space.

    */

public class MaxSumSubArray_KadaneAlgo_DynamicProgram {

    public static void main(String[] args) {

        int[] arr = {-1, 3, -5, 4, 6, -1, 2, -7, 3, -3};

        int[] result = findMaxSumIndex(arr);
        System.out.println("start index :" + result[0]);
        System.out.println("End index :" + result[1]);
        System.out.println("Sum :" + result[2]);

    }

    private static int[] findMaxSumIndex(int[] arr) {
        int[] result = new int[3];
        int maxSumTillNow = Integer.MIN_VALUE;

        int tempStartIndex = 0;
        int tempSum = 0;

        for (int i = 0; i < arr.length; i++) {
            tempSum = tempSum + arr[i];

            if (tempSum > maxSumTillNow) {
                maxSumTillNow = tempSum;
                result[0] = tempStartIndex;
                result[1] = i;
                result[2] = maxSumTillNow;
            }

            //Important Condition to reset
            if (tempSum < 0) {
                tempSum = 0;
                tempStartIndex = i + 1;
            }
        }
        return result;
    }
}


