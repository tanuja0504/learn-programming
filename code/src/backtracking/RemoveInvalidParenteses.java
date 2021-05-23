package backtracking;

import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParenteses {
    public static List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        int validLen = s.length() - findInvalid(s);
        helper(validLen, 0, 0, result, new StringBuilder(), s);
        return result;
    }

    public static void helper(int validLen, int start, int open, List<String> result, StringBuilder sb, String s) {
        System.out.println(sb);
        if (open < 0 || start > s.length()) {
            return;
        }
        if (sb.length() == validLen && open == 0) {
            if (!result.contains(sb.toString())) {
                result.add(new String(sb.toString()));
            }
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (s.charAt(i) != '(' && s.charAt(i) != ')') {
                sb.append(s.charAt(i));
                helper(validLen, i + 1, open, result, sb, s);
            } else if (open <= 0 && s.charAt(i) == ')') {
                continue;
            } else if (s.charAt(i) == '(') {
                sb.append(s.charAt(i));
                helper(validLen, i + 1, open + 1, result, sb, s);
            } else if (s.charAt(i) == ')') {
                if (i > 1 && s.charAt(i - 1) == ')') {
                    continue;
                }
                sb.append(s.charAt(i));
                helper(validLen, i + 1, open - 1, result, sb, s);
            }
            int size = sb.length() - 1;
            sb.deleteCharAt(size);
        }
    }

    public static int findInvalid(String s) {
        int open = 0;
        int invalid = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '(' && s.charAt(i) != ')') {
                continue;
            } else if (s.charAt(i) == '(') {
                open++;
            } else if (open > 0 && s.charAt(i) == ')') {
                open--;
            } else {
                invalid++;
            }
        }
        invalid = invalid + open;
        return invalid;
    }

    public static void main(String[] args) {
        System.out.println(removeInvalidParentheses("()())()"));
    }
}
