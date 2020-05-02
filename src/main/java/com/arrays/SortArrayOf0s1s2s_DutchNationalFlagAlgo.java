package com.arrays;

/**
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

    Dutch national flag problem : algorithm
    Start with three pointers : reader, low and high.
    reader and low are initialized as 0 and high is initialized as last element of array as size-1.
    reader will be used to scan the array while low and high will be used to swap elements to their desired positions.
    Starting with current position of reader, follow below steps, keep in mind we need 0 at start of array
    If element at index reader is 0, swap element at reader with element at low and increment low and reader by 1.
    If element at reader is 1, do not swap and increment reader by 1.
    If element at reader is 2, swap element at reader with element at high and decrease high by 1

    Actually, three pointers divide array into four parts.  Red, white, unknown and Blue.
    Every element is taken from unknown part and put into its right place.
    So all three other parts expand while unknown part shrinks.

Best Solution
https://algorithmsandme.com/dutch-national-flag-problem/
*/


public class SortArrayOf0s1s2s_DutchNationalFlagAlgo {

        public static void swap(int[] input, int i, int j){
            int temp =  input[i];
            input[i] = input[j];
            input[j] = temp;
        }

        public static void dutchNationalFalgAlgorithm(int [] input){

            //initialize all variables
            int reader = 0;
            int low = 0;
            int high = input.length - 1;

            while(reader <= high){
            /*
              input always holds a permutation of the
              original data with input(0..(lo-1)) =0,
              input(lo..(reader-1))=1, input(reader..hi) is
              untouched, and input((hi+1)..(input.length-1)) = 2
            */
                if(input[reader] == 0){
                /*When element at reader is 0, swap
                element at reader with element at index
                low and increment reader and low*/
                    swap(input, reader, low);
                    reader++;
                    low++;
                }
                else if(input[reader] == 1){
                /* if element at reader is just
                increment reader by 1 */
                    reader++;
                }
                else if(input[reader] == 2){
                /* If element at reader is 2, swap
                 element at reader with element at
                 high and decrease high by 1 */
                    swap(input, reader, high);
                    high--;
                }
                else{
                    System.out.println("Bad input");
                    break;
                }
            }

        }
        public static void main(String[] args) {
            int[] input = {2,2,1,1,0,0,0,1,1,2};

            dutchNationalFalgAlgorithm(input);

            for(int i=0; i<input.length; i++){
                System.out.print(" " + input[i]);
            }
        }
    }

