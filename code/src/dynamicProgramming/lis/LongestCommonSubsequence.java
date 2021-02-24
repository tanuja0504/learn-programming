package dynamicProgramming.lis;

public class LongestCommonSubsequence {
    public static int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() <= 0 || text2.length() <= 0) {
            return 0;
        }
        int m = text1.length();
        int n = text2.length();
        if (text1.charAt(m - 1) == text2.charAt(n - 1)) {
            return 1 + longestCommonSubsequence(text1.substring(0, m - 1), text2.substring(0, n - 1));
        } else {
            return Math.max(longestCommonSubsequence(text1, text2.substring(0, n - 1))
                    , longestCommonSubsequence(text1.substring(0, m - 1), text2));
        }
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("pmjghexybyrgzczy", "hafcdqbgncrcbihkd"));
    }
}
