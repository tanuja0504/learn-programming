package string;

public class UniqueChar {
    public static int firstUniqChar(String s) {
        int count[] = new int[26];
        char input[] = s.toCharArray();
        for (char c : input) {
            int i = c - 'a';
            count[i] = 1 + count[i];
        }
        for (int i = 0; i < input.length; i++) {
            int j = input[i] - 'a';
            if (count[j] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leelcode"));
    }
}
