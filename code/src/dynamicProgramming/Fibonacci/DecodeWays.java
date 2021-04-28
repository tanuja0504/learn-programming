package dynamicProgramming.Fibonacci;

import java.util.HashSet;
import java.util.Set;

public class DecodeWays {
    public static int numDecodings(String s) {
        //Either current char or current-1 char are valid
        //If current is valid, no of ways remains same
        //If current is invalid no of ways become 0
        //If current and current-1 combination is valid add current ways + current-2 ways
        int m = s.length() + 1;
        int dp[] = new int[m];
        dp[0] = 1;

        if (verify(s.substring(0, 1))) {
            dp[1] = 1;
        } else {
            return 0;
        }

        for (int i = 2; i < m; i++) {
            if (verify(s.substring(i - 1, i))) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = 0;
            }
            if (verify(s.substring(i - 2, i))) {
                dp[i] = dp[i] + dp[i - 2];
            }
            if (dp[i] == 0) {
                return 0;
            }
        }
        return dp[m - 1];
    }

    public static boolean verify(String s) {
        if (s.charAt(0) == '0') {
            return false;
        }
        int temp = Integer.parseInt(s);
        if (temp > 0 && temp <= 26) {
            return true;
        }
        return false;
    }
    public static int isValid(String s) {
        int temp = Integer.parseInt(s);
        Set<Integer> hset = new HashSet<>();
        for (int i = 3; i < 10; i++) {
            hset.add(i * 10);
        }
        if (s.startsWith("0")) {
            return 0;
        }
        if (temp == 10 || temp == 20) {
            return 1;
        }
        if (temp >= 11 && temp <= 26) {
            return 2;
        }

        if (temp <= 1 && temp <= 9) {
            return 1;
        }
        if (hset.contains(temp)) {
            return 0;
        }

        return 1;
    }

    public static void main(String[] args) {
        System.out.println(verify("01"));
        System.out.println(numDecodings("2101"));
    }
}
