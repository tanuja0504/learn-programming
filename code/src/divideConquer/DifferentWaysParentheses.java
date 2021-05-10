package divideConquer;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysParentheses {
    public static List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < expression.length(); i++) {
            char t = expression.charAt(i);
            if (isOperator(t)) {
                //Divide in two parts and solve recursively
                //Eg: For expression 2-1-1, send 2 in part1 and 1-1 in part2
                List<Integer> part1 = diffWaysToCompute(expression.substring(0, i));
                List<Integer> part2 = diffWaysToCompute(expression.substring(i + 1));
                System.out.println(part1);
                for (int p1 : part1) {
                    for (int p2 : part2) {
                        if (t == '+') {
                            result.add(p1 + p2);
                        } else if (t == '-') {
                            result.add(p1 - p2);
                        } else if (t == '*') {
                            result.add(p1 * p2);
                        }
                    }
                }
            }
        }
        if (result.size() == 0) {
            result.add(Integer.parseInt(expression));
        }
        return result;
    }

    public static boolean isOperator(char c) {
        return (c == '+' || c == '-' || c == '*') ? true : false;
    }


    public static void main(String[] args) {
        String expression = "2*3-4*5";
        System.out.println(diffWaysToCompute(expression));
    }
}
