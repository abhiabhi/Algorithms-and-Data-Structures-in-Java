package com.stack;

import java.util.HashMap;
import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * <p>
 * Analysis
 * <p>
 * A typical problem which can be solved by using a stack data structure.
 */
public class ParenthesisChecker {

    public static boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if (map.keySet().contains(curr)) { /**if the character is in keySet means its opening brace
                                                    we push it onto the Stack*/
                stack.push(curr);
            } else if (map.values().contains(curr)) { /** if character is in values means its closing brace
                                                           so we pop it out and check with curr */
                if (!stack.empty() && map.get(stack.peek()) == curr) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    public static void main (String args[]){
       String input = "[()]{}{[()()]()}";
        System.out.println("isValid : "+isValid(input));
    }
}
