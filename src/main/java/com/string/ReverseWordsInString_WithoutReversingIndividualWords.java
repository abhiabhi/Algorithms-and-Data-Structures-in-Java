package com.string;

import java.util.Stack;

/**
 * Given a String of length S,
 * reverse the whole string without reversing the individual words in it. Words are separated by dots.
 */
public class ReverseWordsInString_WithoutReversingIndividualWords {

    public static void main (String args[]){
        String input = "I.love.potato";
        System.out.println("reverseWord : "+ reverseWord(input));

        System.out.println("reverseWordWithoutStack : " + reverseWordWithoutStack(input));
    }

    private static StringBuilder reverseWord(String input) {
        Stack<String> stack = new Stack<>();
        StringBuilder output = new StringBuilder();
        String[] arr =  input.split("[.]");

        for(String s : arr){
            stack.push(s);
        }

        while(!stack.isEmpty()){
            output.append(stack.pop()).append(".");
        }
        return output;

    }

    /**
     * Solution without Stack. This is reduce space taken by stack in above solution.
     * @param input
     * @return
     */
    private static StringBuilder reverseWordWithoutStack(String input) {
        String s[] = input.split("[.]");
        StringBuilder ans = new StringBuilder();
        for (int i = s.length - 1; i >= 0; i--) {
            ans.append(s[i]).append(".");
        }
        return ans;
    }

}
