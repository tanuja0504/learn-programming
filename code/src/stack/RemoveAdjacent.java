package stack;

import java.util.Stack;

public class RemoveAdjacent {
    public static String removeDuplicates(String S) {
        Stack<Character> input = new Stack<Character>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (!input.isEmpty() && input.peek() == S.charAt(i)) {
                input.pop();
            } else {
                input.push(S.charAt(i));
            }
        }
        if (!input.isEmpty()) {
            for (int i = 0; i <= input.size(); i++) {
                sb.append(input.pop());
            }
        } else {
            sb.append("");
        }
        return sb.reverse().toString();
    }

    public static void main(String as[]) {
        System.out.println(removeDuplicates("abbbabaaa"));
    }
}
