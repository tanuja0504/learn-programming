package string;

import java.util.HashSet;
import java.util.Set;

public class ReverseVowel {
    public static String reverseVowels(String s) {
        Set<Character> vowel = new HashSet<>();
        vowel.add('a');
        vowel.add('e');
        vowel.add('i');
        vowel.add('o');
        vowel.add('u');
        vowel.add('A');
        vowel.add('E');
        vowel.add('I');
        vowel.add('O');
        vowel.add('U');
        int high = s.length() - 1;
        int low = 0;
        char input[] = s.toCharArray();
        StringBuilder result = new StringBuilder();
        while (low < high) {
            while (low < high && !vowel.contains(s.charAt(low))) {
                low++;
            }
            while (low < high && !vowel.contains(s.charAt(high))) {
                high--;
            }
            char t = input[low];
            input[low] = input[high];
            input[high] = t;
            low++;
            high--;

        }
        for (char c : input) {
            result.append(c);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseVowels("leetcode"));
    }
}
