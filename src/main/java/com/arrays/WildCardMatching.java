package com.arrays;

/**
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * <p>
 * Input:
 * s = "cb"
 * p = "?a"
 * Output: false
 * Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 * <p>
 * Time complexity of above solution is O(m x n). Auxiliary space used is also O(m x n).
 * where m = length of pattern
 * n = length of String
 */

public class WildCardMatching {

    public boolean isMatch(String s, String p) {
        char[] str = s.toCharArray();
        char[] pattern = p.toCharArray();

        //replace multiple * with one *
        //e.g a**b***c --> a*b*c
        int writeIndex = 0;
        boolean isFirst = true;
        for (int i = 0; i < pattern.length; i++) {
            if (pattern[i] == '*') {
                if (isFirst) {
                    pattern[writeIndex++] = pattern[i];
                    isFirst = false;
                }
            } else {
                pattern[writeIndex++] = pattern[i];
                isFirst = true;
            }
        }

        boolean T[][] = new boolean[str.length + 1][pattern.length + 1];

        if (writeIndex > 0 && pattern[0] == '*') {
            T[0][1] = true;
        }

        // base case
        T[0][0] = true;

        /**
         * Rules
         * 1) if the value at boolean_array[i][j] is a matching character or a “?”.
         *      boolean_array[i][j] = boolean_array[i-1][j-1] (means diagonal)
         *
         * 2) if the value at at boolean_array[i][j] is “*”.
         *      boolean_array[i][j] = boolean_array[i][j-1] || boolean_array[i-1][j] (means one one left or one on top whichever is true)
         */

        for (int i = 1; i <= str.length; i++) {
            for (int j = 1; j <= pattern.length; j++)
                if (pattern[j - 1] == '?' || str[i - 1] == pattern[j - 1]) {
                    T[i][j] = T[i - 1][j - 1]; //diagonal
                } else if (pattern[j - 1] == '*') {
                    T[i][j] = T[i - 1][j] || T[i][j - 1];
                }
        }

        return T[str.length][pattern.length];
    }


    public static void main(String args[]) {
        WildCardMatching wcm = new WildCardMatching();
        System.out.println(wcm.isMatch("xbylmz", "x?y*z"));
    }
}
