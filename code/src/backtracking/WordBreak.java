package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        int m = s.length();
        boolean result = false;
        boolean dp[][] = new boolean[m + 1][m + 1];
        dp[0][0] = true;
        Set<Integer> set = new HashSet<>();
        set.add(0);
        for (int i = 1; i <= m; i++) {
            for (int j = i; j <= m; j++) {
                String t1 = s.substring(i - 1, j - 1);
                if (wordDict.contains(t1) && set.contains(j - t1.length() - 1)) {
                    dp[i][j] = true;
                    set.add(j);
                }
            }
        }
        System.out.println(set);
        print(dp);
        for (int i = 0; i <= m; i++) {
            result = result || dp[i][m];
        }
        return result;
    }

    public static void print(boolean dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> dict = new ArrayList<>();
        dict.add("leet");
        dict.add("code");
        dict.add("and");
        dict.add("dog");
        dict.add("sand");
        System.out.println(wordBreak(s, dict));
    }
}
