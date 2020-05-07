package com.string;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Given a string S consisting of lowercase Latin Letters. Find the first non repeating character in S.
 */
public class FindFirstNonRepeatingCharacter {

    public static void main(String args[]) {
        String input = "ABCDHJACDHJ";
        int c = findFirstNonRepeatingChar(input);
        if (c == -1) {
            System.out.println("findFirstNonRepeatingChar : " + "Not Found");
        } else {
            System.out.println("findFirstNonRepeatingChar : " + (char) c);
        }
    }

    private static int findFirstNonRepeatingChar(String input) {
        /**insertion order will preserved as we are using linkedHashMap */
        Map<Character, Integer> map = new LinkedHashMap<>();

        /** store frequency of each character in map*/
        for (char c : input.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        for (char c : map.keySet()) {
            if (map.get(c) == 1) {
                return c;
            }
        }
        return -1;
    }
}
