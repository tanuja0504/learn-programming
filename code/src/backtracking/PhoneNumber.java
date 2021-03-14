package backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PhoneNumber {
    static Map<Character, String> dict;

    public static List<String> letterCombinations(String digits) {
        dict.putIfAbsent('2', "abc");
        dict.putIfAbsent('3', "def");
        dict.putIfAbsent('4', "ghi");
        dict.putIfAbsent('5', "jkl");
        dict.putIfAbsent('6', "mno");
        dict.putIfAbsent('7', "pqrs");
        dict.putIfAbsent('8', "tuv");
        dict.putIfAbsent('9', "wxyz");
        List<String> result = new ArrayList<String>();
        helper(digits, 0, dict, result, new StringBuilder());
        return result;
    }

    public static void helper(String digits, int start, Map<Character, String> dict, List<String> result, StringBuilder temp) {

    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
