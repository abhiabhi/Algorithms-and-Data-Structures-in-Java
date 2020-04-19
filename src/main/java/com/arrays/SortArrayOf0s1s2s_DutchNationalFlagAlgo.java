package com.arrays;

/*
 Dutch National Flag Algorithm, or 3-way Partitioning

Sort an array of 0s, 1s and 2s
Given an array A[] consisting 0s, 1s and 2s.
The task is to write a function that sorts the given array.
The functions should put all 0s first, then all 1s and all 2s in last.
https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/

Examples:

Input: {0, 1, 2, 0, 1, 2}
Output: {0, 0, 1, 1, 2, 2}

Input: {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1}
Output: {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2}

Simplest Solution
Count the number of 0’s, 1’s and 2’s. After Counting, put all 0’s first, then 1’s and lastly 2’s in the array.
We traverse the array two times. Time complexity will be O(n).

Best Solution
https://algorithmsandme.com/dutch-national-flag-problem/
 */

public class SortArrayOf0s1s2s_DutchNationalFlagAlgo {
/*
    Dutch national flag problem : algorithm
    Start with three pointers : reader, low and high.
    reader and low are initialized as 0 and high is initialized as last element of array as size-1.
    reader will be used to scan the array while low and high will be used to swap elements to their desired positions.
    Starting with current position of reader, follow below steps, keep in mind we need 0 at start of array
    If element at index reader is 0, swap element at reader with element at low and increment low and reader by 1.
    If element at reader is 1, do not swap and increment reader by 1.
    If element at reader is 2, swap element at reader with element at high and decrease high by 1*/


    public void dutchNationalFlagAlgorithm(){

    }

    public static void sort012(int arr[], int arr_size) {
        int countZero = 0;
        int countOne = 0;
        int countTwo = 0;
        for (int a : arr) {
            if (a == 0) {
                countZero++;
            } else if (a == 1) {
                countOne++;
            } else if (a == 2) {
                countTwo++;
            }
        }

        int i = 0;
        while (countZero > 0) {
            arr[i] = 0;
            countZero--;
            i++;
        }

        while (countOne > 0) {
            arr[i] = 1;
            countOne--;
            i++;
        }

        while (countTwo > 0) {
            arr[i] = 2;
            countTwo--;
            i++;
        }

    }


    /* Utility function to print array arr[] */
    static void printArray(int arr[], int arr_size) {
        int i;
        for (i = 0; i < arr_size; i++)
            System.out.print(arr[i] + " ");
        System.out.println("");
    }

    /*Driver function to check for above functions*/
    public static void main(String[] args) {
        int arr[] = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        int arr_size = arr.length;
        sort012(arr, arr_size);
        System.out.println("Array after seggregation ");
        printArray(arr, arr_size);
    }
}
