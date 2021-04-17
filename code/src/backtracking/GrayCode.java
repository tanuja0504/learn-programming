package backtracking;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    //https://www.youtube.com/watch?v=KOD2BFauQbA
    public static List<Integer> grayCode(int n) {
        List<String> temp = helper(n);
        List<Integer> result = new ArrayList<>();
        for (String s : temp) {
            result.add(Integer.parseInt(s, 2));
        }
        return result;
    }

    public static List<String> helper(int n) {
        if (n == 1) {
            List<String> result = new ArrayList<>();
            result.add("0");
            result.add("1");
            return result;
        }
        List<String> temp = helper(n - 1);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < temp.size(); i++) {
            result.add("0" + temp.get(i));
        }
        for (int i = temp.size() - 1; i >= 0; i--) {
            result.add("1" + temp.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(grayCode(3));
    }
}
