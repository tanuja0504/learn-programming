package array;

public class Atoi {
    public static int myAtoi(String str) {
        int result = 0;
        char input[] = str.toCharArray();
        int i = 0;

        while (input[i] == ' ' && i < str.length()) {
            i++;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("4981"));
    }
}
