package string;

public class ReverseString {
    public static String reverseWords(String s) {

        String temp = reverse(s);
        String tempInput[] = temp.split(" ");
        if (s.length() <= 1 || tempInput.length <= 1) {
            return s;
        }
        System.out.println(tempInput.length);
        StringBuilder sb = new StringBuilder();
        for (String t : tempInput) {
            System.out.println(t);
            if (!t.equals("") && t.length() > 0) {
                sb.append(reverse(t));
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }

    public static String reverse(String s) {
        if (s.length() <= 1) {
            return s;
        }
        int low = 0;
        int high = s.length() - 1;
        char input[];
        input = s.toCharArray();
        while (low < high) {
            char temp = input[low];
            input[low] = input[high];
            input[high] = temp;
            low++;
            high--;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : input) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("The KY is    Blue"));
    }
}
