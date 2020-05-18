package backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParen {

    char c1 = '(';
    char c2 = ')';

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        findString(list, new StringBuilder(), n, n, 0);
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

    public static void main(String[] args) {
        GenerateParen obj = new GenerateParen();
        List<String> result = obj.generateParenthesis(3);
        for (String str : result) {
            System.out.println(str);
        }
    }
}
