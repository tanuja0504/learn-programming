package string;

public class ReverseWordsInString {
    public static String reverseWords(String s) {
        char input[] = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            char c = input[start];
            input[start] = input[end];
            input[end] = c;
            start++;
            end--;
        }
        int slow = 0;
        int fast = -1;
        for (int i = 0; i < s.length(); i++) {
            fast++;
            while (input[fast] != ' ' && fast < s.length()) {
                fast++;
            }
            slow = fast - 1;
            while (i < slow) {
                char c = input[i];
                input[i] = input[slow];
                input[slow] = c;
                i++;
                slow--;

            }
        }
        for (int i = 0; i < s.length(); i++) {
            sb.append(input[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("The man is a can"));
    }
}
