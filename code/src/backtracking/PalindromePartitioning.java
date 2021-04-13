package backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        helper(0, result, new ArrayList<String>(), s, s.length());
        return result;
    }

    public static void helper(int k, List<List<String>> result, List<String> temp, String s, int len) {
        if (k >= len) {
            result.add(new ArrayList<>(temp));
        }
        for (int i = k; i < len; i++) {
            if (isPalindrome(s, k, i)) {
                temp.add(s.substring(k, i + 1));
                helper(i + 1, result, temp, s, len);
                int size = temp.size() - 1;
                temp.remove(size);
            }
        }
    }

    public static boolean isPalindrome(String s, int low, int high) {
        System.out.println(low + " " + high);
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }
}
