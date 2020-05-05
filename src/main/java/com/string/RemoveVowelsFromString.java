package com.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveVowelsFromString {

    public static void main(String args[]) {
        String input = "hello";
        StringBuilder output = removeVowels(input);
        System.out.println(output);
    }

    private static StringBuilder removeVowels(String input) {
        Set<Character> vowelSet = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        StringBuilder output = new StringBuilder();
        for (Character c : input.toCharArray()) {
            if (!vowelSet.contains(c)) {
                output.append(c);
            }
        }
        return output;

    }
}
