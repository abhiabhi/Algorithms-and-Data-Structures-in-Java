package com.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem Statement
 * There is a special keyboard with all keys in a single row.
 * <p>
 * You have given a string keyboard of length 26 indicating the layout of the keyboard (indexed from 0 to 25),
 * initially your finger is at index 0. To type a character, you have to move your finger to the index of the desired character.
 * The time taken to move your finger from index i to index j is |i – j|.
 * <p>
 * You want to type a string word. Write a program to calculate how much time it takes to type it with one finger.
 * <p>
 * Input :- Keyboard = "abcdefghijklmnopqrstuvwxyz", Word = "cba"
 * Output :- 4
 * Input :- Keyboard = "pqrstuvwxyzabcdefghijklmno", Word = "hello"
 * Output :- 31
 */

public class SingleRowKeyboard {
    public static void main(String[] args) {
        int result = calculateTime("pqrstuvwxyzabcdefghijklmno", "rqp");
        System.out.println(result);
    }

    private static int calculateTime(String keyboard, String word) {
        Map<Character, Integer> map = new HashMap<>();
        int pos = 0;
        for (char c : keyboard.toCharArray()) {
            map.put(c, pos++);
        }

        int total = 0;
        int current = 0;
        for (char c : word.toCharArray()) {
            total += Math.abs(current - map.get(c));
            current = map.get(c);
        }
        return total;
    }

}
