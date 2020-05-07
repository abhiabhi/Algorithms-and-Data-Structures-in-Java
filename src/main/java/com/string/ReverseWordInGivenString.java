package com.string;

import java.util.Stack;

public class ReverseWordInGivenString {

    public static void main (String args[]){
        String input = "HELLO";
        System.out.println("reverseWord : "+ reverseWord(input));
    }

    private static StringBuilder reverseWord(String input) {
        Stack<Character> stack = new Stack<>();
        StringBuilder output = new StringBuilder();

        for(char c : input.toCharArray()){
            stack.push(c);
        }

        while(!stack.isEmpty()){
            output.append(stack.pop());
        }
        return output;

    }

}
