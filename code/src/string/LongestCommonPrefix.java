package string;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        String result = "";

        if (strs.length == 0) {
            return result;
        }
        String minLength = strs[0];
        for (String s : strs) {
            if (s.length() < minLength.length()) {
                minLength = s;
            }
        }
        int match = minLength.length();
        for (String s : strs) {
            int i = 0;
            int matchCount = 0;
            while (i < minLength.length()) {
                if (minLength.charAt(i) == s.charAt(i)) {
                    matchCount++;
                } else {
                    break;
                }
                i++;
            }
            match = Math.min(matchCount, match);
        }
        result = minLength.substring(0, match);
        System.out.println(minLength + " " + result);
        return result;
    }

    public static void main(String[] args) {
        String[] strs = {"cir", "car", "care"};
        System.out.println(longestCommonPrefix(strs));
    }
}
