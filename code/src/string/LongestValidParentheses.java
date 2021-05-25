package string;

import java.util.Stack;

public class LongestValidParentheses {
    public static int longestValidParentheses(String s) {
        int k = s.length();
        boolean record[] = new boolean[k];
        Stack<Integer> st = new Stack<>();
        int result = 0;
        int current = 0;
        int i = 0;
        while (i < k) {
            if (s.charAt(i) == '(') {
                st.push(i);
            } else if (!st.isEmpty() && s.charAt(i) == ')') {
                record[st.pop()] = true;
                record[i] = true;
            }
            i++;
        }
        for (boolean b : record) {
            if (b) {
                current++;
                result = Math.max(result, current);
            } else {
                current = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("()"));
        System.out.println(longestValidParentheses("(()"));
        System.out.println(longestValidParentheses("()())"));
        System.out.println(longestValidParentheses(")()())"));
        System.out.println(longestValidParentheses(""));
        System.out.println(longestValidParentheses("()(()"));
    }
}
