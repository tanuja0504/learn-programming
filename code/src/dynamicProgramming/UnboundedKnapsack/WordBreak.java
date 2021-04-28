package dynamicProgramming.UnboundedKnapsack;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        int m = s.length();
        boolean dp[] = new boolean[m + 1];
        List<Integer> index = new ArrayList<>();
        index.add(-1);
        for (int i = 1; i <= m; i++) {
            System.out.println(i);
            for (int j : index) {
                System.out.println(s.substring(j + 1, i));
                if (wordDict.contains(s.substring(j + 1, i))) {
                    dp[i] = true;
                }
            }
            if (dp[i] == true) {
                index.add(i - 1);
            }
            System.out.println(index);
        }
        for (boolean b : dp) {
            System.out.print(b + " ");
        }
        return dp[m];
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
