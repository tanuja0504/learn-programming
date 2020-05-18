package string;

import java.util.Stack;

public class BackString {
    public static boolean backspaceCompare(String S, String T) {
        boolean result = false;
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();
        Stack<Character> s1 = new Stack<>();
        Stack<Character> t1 = new Stack<>();
        for (char a : s) {
            if (a == '#' && !s1.isEmpty()) {
                s1.pop();
            } else if (a == '#') {

            } else {
                s1.push(a);
            }
        }
        for (char a : t) {
            if (a == '#' && !t1.isEmpty()) {
                t1.pop();
            } else if (a == '#') {

            } else {
                t1.push(a);
            }
        }
        while (!s1.isEmpty() && !t1.isEmpty()) {
            if (s1.peek() == t1.peek()) {
                s1.pop();
                t1.pop();
            } else {
                return result;
            }
        }
        if (s1.isEmpty() && t1.isEmpty()) {
            result = true;
        }
        return result;
    }

    public static void main(String[] args) {
        String S = "y#fo##f";
        String T = "y#f#o##f";
        System.out.println(backspaceCompare(S, T));
    }
}