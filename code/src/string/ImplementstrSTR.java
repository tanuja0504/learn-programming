package string;

public class ImplementstrSTR {
    public static int strStr(String haystack, String needle) {
        int low = 0;
        int high = 0;
        int start = 0;
        int end = 0;
        int m = haystack.length();
        int n = needle.length();
        while (high < m) {
            high = low;
            end = start;
            while (high < m && end < n) {
                if (haystack.charAt(high) != needle.charAt(end)) {
                    high = low;
                    end = start;
                    break;
                }
                high++;
                end++;
            }
            if (haystack.substring(low, high).equals(needle)) {
                return low;
            }
            low++;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("hello", "ll"));
    }
}
