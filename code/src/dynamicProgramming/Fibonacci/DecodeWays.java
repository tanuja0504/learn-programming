package dynamicProgramming.Fibonacci;

public class DecodeWays {
    int result = 0;

    public int numDecodings(String s) {
        if (s.startsWith("0")) {
            result = 0;
        }
        result = helper(s, 0);
        return result;
    }

    public int helper(String s, int start) {
        if (start >= s.length()) {
            return 0;
        }
        for (int i = start; i < s.length(); i++) {
            String t = s.substring(start, i + 1);
            if (Integer.parseInt(s) == 0 || Integer.parseInt(s) < 27) {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println();
    }
}
