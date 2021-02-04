package string;

public class LastWordLen {
    public static int lengthOfLastWord(String s) {
        s = s.trim();
        int i = s.length() - 1;
        while (i >= 0) {
            if (s.charAt(i) == ' ') {
                return s.length() - i - 1;
            }
            i--;
        }
        if (!s.contains(" ")) {
            return s.length();
        }
        return 0;
    }

    public static void main(String[] args) {
        String str = "a ";
        System.out.println(lengthOfLastWord(str));
    }
}
