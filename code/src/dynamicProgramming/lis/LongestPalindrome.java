package dynamicProgramming.lis;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    static int maxSofar = 0;
    static String result = "";
    static Map<String, Boolean> hmap = new HashMap<>();

    public static String longestPalindrome(String s) {
        hmap.putIfAbsent(s, true);
        if (s.length() <= 1) {
            if (maxSofar < s.length()) {
                result = s;
                maxSofar = Math.max(maxSofar, s.length());
            }
            return s;
        }
        if (s.length() > maxSofar && isPalindrome(s)) {
            result = s;
            maxSofar = Math.max(maxSofar, s.length());
        }

        String x = s.substring(0, s.length() - 1);
        if (!hmap.containsKey(x) && x.length() > maxSofar) {
            longestPalindrome(x);
        }
        String y = s.substring(1, s.length());
        if (!hmap.containsKey(y) && y.length() > maxSofar) {
            longestPalindrome(y);
        }
        return result;
    }

    public static boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        boolean result = true;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                result = false;
                break;
            }
            start++;
            end--;
        }
        return result;
    }

    public static int longestPalindromeDP(String s) {
        int len = s.length();
        StringBuilder a = new StringBuilder(s);
        a = a.reverse();
        String temp = a.toString();
        int[][] dp = new int[len + 1][len + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp.length; j++) {
                if (s.charAt(i - 1) == temp.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        printMat(dp);
        return dp[len][len];
    }

    public static String longestPalindromeDPStr(String s) {
        int len = s.length();
        StringBuilder a = new StringBuilder(s);
        a = a.reverse();
        String temp = a.toString();
        String[][] dp = new String[len + 1][len + 1];
        String result = "";
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = "";
        }
        for (int i = 0; i < dp.length; i++) {
            dp[0][i] = "";
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (s.charAt(i - 1) == temp.charAt(j - 1)) {
                    dp[i][j] = s.charAt(i - 1) + dp[i - 1][j - 1];
                    if (dp[i][j].length() >= result.length() && isPalindrome(dp[i][j])) {
                        result = dp[i][j];
                    }
                } else {
                    dp[i][j] = "";
                }
            }
        }
        printMat(dp);
        return result;
    }

    public static void printMat(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void printMat(String dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                System.out.print(dp[i][j] + " | ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        //System.out.println(longestPalindromeDPStr("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsod"));
        //System.out.println(longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
        //String a="kyyrjtdplseovzwjkykrjwhxquwxsfsorjiumvxjhjmgeueafubtonhlerrgsgohfosqssmizcuqryqomsipovhhodpfyudtusjhonlqabhxfahfcjqxyckycstcqwxvicwkjeuboerkmjshfgiglceycmycadpnvoeaurqatesivajoqdilynbcihnidbizwkuaoegmytopzdmvvoewvhebqzskseeubnretjgnmyjwwgcooytfojeuzcuyhsznbcaiqpwcyusyyywqmmvqzvvceylnuwcbxybhqpvjumzomnabrjgcfaabqmiotlfojnyuolostmtacbwmwlqdfkbfikusuqtupdwdrjwqmuudbcvtpieiwteqbeyfyqejglmxofdjksqmzeugwvuniaxdrunyunnqpbnfbgqemvamaxuhjbyzqmhalrprhnindrkbopwbwsjeqrmyqipnqvjqzpjalqyfvaavyhytetllzupxjwozdfpmjhjlrnitnjgapzrakcqahaqetwllaaiadalmxgvpawqpgecojxfvcgxsbrldktufdrogkogbltcezflyctklpqrjymqzyzmtlssnavzcquytcskcnjzzrytsvawkavzboncxlhqfiofuohehaygxidxsofhmhzygklliovnwqbwwiiyarxtoihvjkdrzqsnmhdtdlpckuayhtfyirnhkrhbrwkdymjrjklonyggqnxhfvtkqxoicakzsxmgczpwhpkzcntkcwhkdkxvfnjbvjjoumczjyvdgkfukfuldolqnauvoyhoheoqvpwoisniv";
        String a = "aacabdkacaa";
        System.out.println(longestPalindromeDPStr(a));

    }
}
