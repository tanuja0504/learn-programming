package string;

public class FindDifference {
    public static char findTheDifference(String s, String t) {
        char result = ' ';
        int sTable[] = new int[27];
        int tTable[] = new int[27];
        int m = s.length() - 1;
        int n = t.length() - 1;
        //System.out.println(t.charAt(n)-96);
        while (m >= 0) {
            sTable[s.charAt(m) - 96]++;
            m--;
        }

        while (n >= 0) {
            tTable[t.charAt(n) - 96]++;
            n--;
        }
        for (int i = 0; i < 27; i++) {
            if (sTable[i] != tTable[i]) {
                result = (char) (i + 96);
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        char c = 'a';
        int a = c;
        //System.out.println(a);
        System.out.println(findTheDifference("a", "ae"));
    }
}
