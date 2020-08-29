package recursion;

public class ReverseString {
    int count;

    public void reverseString(char[] s) {
        int n = (s.length - 1) - count;
        if (n <= 0)
            return;
        count++;
        reverseString(s);
        System.out.println("Char=" + s[n]);
    }


    public static void main(String[] args) {
        ReverseString obj = new ReverseString();
        char[] s = {'a', 'b', 'c', 'D'};
        obj.reverseString(s);
    }
}