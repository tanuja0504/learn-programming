package dynamicProgramming.LCS;

public class ShortestPalindrome {
    public static String shortestPalindrome(String s) {
        boolean dp[] = new boolean[s.length()];
        dp[0] = true;
        for (int i = 1; i < s.length(); i++) {
            if (isPalindrome(s.substring(0, i + 1))) {
                dp[i] = true;
            }
        }
        for (boolean b : dp) {
            System.out.print(b + " ");
        }
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;
        while (i > 0) {
            if (dp[i]) {
                break;
            } else {
                sb.append(s.charAt(i));
            }
            i--;
        }
        sb.append(s);
        return sb.toString();
    }

    public static boolean isPalindrome(String s) {
        int low = 0;
        int high = s.length() - 1;
        while (low < high) {
            if (s.charAt(low) != s.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(shortestPalindrome("aacecaaa"));
    }
}
