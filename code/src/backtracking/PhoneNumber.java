package backtracking;

import java.util.*;

public class PhoneNumber {
    static Map<Character, String> dict;

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if (digits.length() == 0) {
            return result;
        }
        dict = new HashMap<>();
        dict.putIfAbsent('2', "abc");
        dict.putIfAbsent('3', "def");
        dict.putIfAbsent('4', "ghi");
        dict.putIfAbsent('5', "jkl");
        dict.putIfAbsent('6', "mno");
        dict.putIfAbsent('7', "pqrs");
        dict.putIfAbsent('8', "tuv");
        dict.putIfAbsent('9', "wxyz");

        Set<Character> visited = new HashSet<>();
        helper(digits, 0, dict, result, new StringBuilder(), visited);
        return result;
    }

    public static void helper(String digits, int pos, Map<Character, String> dict, List<String> result, StringBuilder temp, Set<Character> visited) {
        if (pos >= digits.length()) {
            result.add(new String(temp));
            return;
        }
        String letter = dict.get(digits.charAt(pos));
        for (int i = 0; i < letter.length(); i++) {
            temp.append(letter.charAt(i));
            visited.add(letter.charAt(i));
            helper(digits, pos + 1, dict, result, temp, visited);
            temp.deleteCharAt(temp.length() - 1);
            visited.remove(letter.charAt(i));
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
