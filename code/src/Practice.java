import java.util.HashSet;
import java.util.Set;

public class Practice {
    public static int numDecodings(String s) {
        int dp[] = new int[s.length() + 1];

        //Populate valid dictionary
        Set<String> dict = new HashSet<>();
        for (int i = 1; i <= 26; i++) {
            dict.add(String.valueOf(i));
        }
        if (s.length() == 0) {
            return 0;
        }

        if (!dict.contains(s.substring(0, 1))) {
            return 0;
        }

        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            if (dict.contains(s.substring(i - 1, i))) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = 0;
            }
            //Check for previous combination
            if (dict.contains(s.substring(i - 2, i))) {
                dp[i] = dp[i] + dp[i - 2];
            }

            if (dp[i] == 0) {
                return 0;
            }

        }
        return dp[s.length()];
    }


    public static void main(String[] args) {
        String s = "11106";
        System.out.println(numDecodings(s));
    }
}
