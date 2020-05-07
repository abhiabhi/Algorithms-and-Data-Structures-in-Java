package com.string;

/**
 * We can scan to both sides for each character.
 * Time O(n^2), Space O(1)
 * If you need better use Manacher's Algorithm with time complexity O(n)
 */

public class LongestPalindromicSubstring_WithoutManacherAlgo {

    public String longestPalindrome(String s) {

        if (s.length() <= 1) {
            return s;
        }
        /**initialize the longest to first character */
        String longest = s.substring(0, 1);

        for (int i = 0; i < s.length(); i++) {

            // get longest palindrome with center of i
            String tmp = helper(s, i, i);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }

            // get longest palindrome with center of i, i+1
            tmp = helper(s, i, i + 1);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }

        }

        return longest;
    }

    // Given a center, either one letter or two letter,
    // Find longest palindrome
    public String helper(String s, int begin, int end) {
        while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) { /** begin and end within boundary && Start and end characters are matching */
            /**Expand the boundaries */
            begin--;
            end++;
        }
        return s.substring(begin + 1, end);
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring_WithoutManacherAlgo palindrome = new LongestPalindromicSubstring_WithoutManacherAlgo();
        String result = palindrome.longestPalindrome("daxah");
        System.out.println("longestPalindrome - " + result);
    }
}
