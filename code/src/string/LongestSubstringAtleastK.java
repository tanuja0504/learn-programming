package string;

public class LongestSubstringAtleastK {
    public static int longestSubstring(String s, int k) {
        if (s.length() < k || s.length() == 0) {
            return 0;
        }
        if (k < 2) {
            return s.length();
        }

        int maxLen = 0;
        int map[] = new int[26];
        char input[] = s.toCharArray();
        for (char c : input) {
            map[c - 'a']++;
        }
        boolean valid = true;
        int winStart = 0;
        for (int winEnd = 0; winEnd < s.length(); winEnd++) {
            if (map[input[winEnd] - 'a'] > 0 && map[input[winEnd] - 'a'] < k) {
                maxLen = Math.max(maxLen, longestSubstring(s.substring(winStart, winEnd), k));
                winStart = winEnd + 1;
                valid = false;
            }
        }
        if (valid) {
            return s.length();
        } else {
            maxLen = Math.max(maxLen, longestSubstring(s.substring(winStart), k));
            return maxLen;
        }
    }

    public static void main(String[] args) {
        String s = "aaaaaaaaaaaabcdefghijklmnopqrstuvwzyz";
        int k = 3;
        System.out.println(longestSubstring(s, k));
    }
}