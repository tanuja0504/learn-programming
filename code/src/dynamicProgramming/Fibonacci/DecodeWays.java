package dynamicProgramming.Fibonacci;

import java.util.HashSet;
import java.util.Set;

public class DecodeWays {
    public static int numDecodings(String s) {
        int dp[] = new int[s.length() + 1];

        if (isValid(s.substring(0, 1)) == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return isValid(s);
        }
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            String t = s.substring(i - 2, i);
            if (isValid(t) == 2) {
                dp[i] += dp[i - 2];
            }
            if (isValid(s.substring(i - 1, i)) == 1) {
                dp[i] += dp[i - 1];
            }
            System.out.println(s.charAt(i - 1) + " " + t + " " + isValid(t) + " " + dp[i]);
        }

        System.out.println();
        for (int num : dp) {
            System.out.print(num + " ");
        }
        System.out.println();
        return dp[s.length()];
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

        System.out.println(numDecodings("11106"));
    }
}
