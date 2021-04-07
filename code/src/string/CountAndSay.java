package string;

public class CountAndSay {
    public static String countAndSay(int n) {
        if (n == 2) {
            return "11";
        }
        if (n == 1) {
            return "1";
        }
        String t = countAndSay(n - 1);
        char input[] = t.toCharArray();
        int len = input.length;
        //int i=0;

        StringBuilder say = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char c = input[i];
            int count = 1;
            while (i < len - 1 && t.charAt(i + 1) == c) {
                i++;
                count++;
            }
            say.append(count);
            say.append(c);
        }
        return say.toString();
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }
}
