package string;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int result = 0;
        Set<Character> hset = new HashSet<>();
        int fast = 0;
        int slow = 0;
        int maxSoFar = 0;
        while (slow <= fast && fast < s.length()) {
            if (hset.contains(s.charAt(fast))) {
                while (hset.contains(s.charAt(fast))) {
                    hset.remove(s.charAt(slow));
                    slow++;
                }
            }
            hset.add(s.charAt(fast));
            fast++;
            maxSoFar = hset.size();
            result = Math.max(result, maxSoFar);
        }

        return result;
    }

    public static void main(String[] args) {
        String str = "qrsvbspk";
        System.out.println(lengthOfLongestSubstring(str));
    }
}
