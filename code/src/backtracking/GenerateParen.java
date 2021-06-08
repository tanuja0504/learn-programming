package backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParen {

    char c1 = '(';
    char c2 = ')';

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        //findString(list, new StringBuilder(), n, n, 0);
        findString1(list, new StringBuilder(), 0, 0, n);
        return list;
    }

    public void findString(List<String> list, StringBuilder s, int leftC, int rightC, int open) {
        if (leftC == 0 && rightC == 0 && s.length() > 0) {
            list.add(s.toString());
            return;
        }
        if (leftC > 0) {
            s.append(c1);
            findString(list, s, leftC - 1, rightC, open + 1);
            s.deleteCharAt(s.length() - 1);
        }
        if (rightC > 0 && open > 0) {
            s.append(c2);
            findString(list, s, leftC, rightC - 1, open - 1);
            s.deleteCharAt(s.length() - 1);
        }
    }

    public void findString1(List<String> list, StringBuilder s, int open, int close, int n) {
        if (open == close && open == n) {
            list.add(new String(s.toString()));
            return;
        }
        if (open > n) {
            return;
        }
        if (open <= close) {
            s.append('(');
            findString1(list, s, open + 1, close, n);
        } else {
            int len = s.length();
            s.append(')');
            findString1(list, s, open, close + 1, n);
            s.setLength(len);
            s.append('(');
            findString1(list, s, open + 1, close, n);
        }
    }

    public static void main(String[] args) {
        GenerateParen obj = new GenerateParen();
        List<String> result = obj.generateParenthesis(3);
        for (String str : result) {
            System.out.println(str);
        }
    }
}
