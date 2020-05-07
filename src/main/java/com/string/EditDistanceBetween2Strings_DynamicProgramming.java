package com.string;


/**
 * https://www.youtube.com/watch?v=b6AGUjqIPsA
 *
 */
public class EditDistanceBetween2Strings_DynamicProgramming {

    public static void main (String args[]){
        String from = "YELLOW";
        String to = "HELLO";
        System.out.println("MinEditDistance:" +editDist(from,to,from.length(),to.length()));
    }

    static int editDist(String from, String to, int m, int n)
    {
        // If first string is empty, the only option is to
        // insert all characters of second string into first
        if (m == 0)
            return n;

        // If second string is empty, the only option is to
        // remove all characters of first string
        if (n == 0)
            return m;

        // If last characters of two strings are same, nothing
        // much to do. Ignore last characters and get count for
        // remaining strings.
        if (from.charAt(m - 1) == to.charAt(n - 1))
            return editDist(from, to, m - 1, n - 1); /** diagonal - blind copy*/

        // If last characters are not same, consider all three
        // operations on last character of first string, recursively
        // compute minimum cost for all three operations and take
        // minimum of three values.

        return 1 + Integer.min(Integer.min(editDist(from, to, m, n - 1), // Insert --just left
                editDist(from, to, m - 1, n)),// Remove  --just above
                editDist(from, to, m - 1, n - 1)); // Replace --just diagonal

    }
}
