package com.arrays;

import java.util.Arrays;

/**
 * Write a program to find the minimum number of platforms needed in a railway station.
 * <p>
 * The arrival and departure time of several trains are provided.
 * Two disparate arrays are given: one with all the arrival times and another with the departure time in 24 hours clock.
 * Write a program to find the minimum number of platforms needed in a given railway station.
 * <p>
 * Solution:
 * <p>
 * Clue: The minimum number of platforms is nothing but the maximum number of trains that rest in the given railway station
 * from the time limit between the arrival of the first train to the departure of the last train.
 * Input:  arr[]  = {9:00,  9:40, 9:50,  11:00, 15:00, 18:00}
 * dep[]  = {9:10, 12:00, 11:20, 11:30, 19:00, 20:00}
 * Output: 3
 * There are at-most three trains at a time (time between 9:40 to 11:00)
 * <p>
 * Sort the timing values given in both the arrays and later check the count of trains at every given time of arrival and departure.
 * The maximum number of trains in the process is taken as the output.
 * <p>
 * arr[]  = {9:00,  9:40, 9:50,  11:00, 15:00, 18:00}
 * dep[]  = {9:10, 12:00, 11:20, 11:30, 19:00, 20:00}
 * <p>
 * Time complexity is O(n + nlog n).  n = traverse the array of n elements + nlogn (for sorting the array)
 * Space Complexity: O(1).
 * As no extra space is required.
 * <p>
 * dynamic programming is used to conserve memory.
 */
public class MinimumPlatforms_Greedy {

    // Returns minimum number of platforms required
    static int findPlatform(int arr[], int dep[], int n) {

        /**important*/
        // Sort arrival and departure arrays
        Arrays.sort(arr);
        Arrays.sort(dep);

        // max_platforms_so_far indicates number of platforms needed at a time
        int max_platforms_so_far = 1, needed_platforms = 1;
        int i = 1, j = 0;

        // Similar to merge in merge sort to process all events in sorted order
        while (i < n && j < n) { /** end the loop when any one iterator completes any one array.*/
            // If next event in sorted order is arrival,
            // increment count of platforms needed
            if (arr[i] <= dep[j])  /**means one more train can before any train could depart so increment the max_platfroms */ {
                max_platforms_so_far++;
                i++;

                // Update result if needed
                if (max_platforms_so_far > needed_platforms)
                    needed_platforms = max_platforms_so_far;
            }

            // Else decrement count of platforms needed
            else {
                max_platforms_so_far--;
                j++;
            }
        }

        return needed_platforms;
    }

    // Driver program to test methods of graph class
    public static void main(String[] args) {
        int arr[] = {900, 940, 950, 1100, 1500, 1800};
        int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
        int n = arr.length;
        System.out.println("Minimum Number of Platforms Required = "
                + findPlatform(arr, dep, n));
    }
}

