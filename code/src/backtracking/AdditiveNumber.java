package backtracking;

public class AdditiveNumber {
    public static boolean isAdditiveNumber(String num) {
        for (int i = 0; i < num.length() - 2; i++) {
            if (num.charAt(i) == '0' && i > 0) {
                break;
            }
            long m = Long.valueOf(num.substring(0, i + 1));
            for (int j = i + 1; j < num.length() - 1; j++) {
                if (num.charAt(j) == '0' && j > i + 1) {
                    break;
                }
                long n = Long.valueOf(num.substring(i + 1, j + 1));
                if (helper(num, j + 1, m, n)) {
                    return true;
                }
            }
        }
        return false;
    }

    //While in the helper function, we check whether there exists a number whose
// value equals to the sum of the two previous numbers.
// If there exists such a number, we do the recursive call to check the reminding part of the string;
// if such a number doesn't, the number represented by the string cannot be an additive number,
// we could just return false.
    public static boolean helper(String num, int index, long m, long n) {
        if (num.length() == index) {
            return true;
        }

        long t = m + n;
        String s = String.valueOf(t);
        // if exceeded or the sum doesn't match
        // use string comparison to avoid things like "12 + 12 = 024"
        if (!num.startsWith(s, index)) {
            return false;
        }
        return helper(num, index + s.length(), n, t);
    }

    public static void main(String[] args) {
        System.out.println(isAdditiveNumber("199100"));
    }
}
