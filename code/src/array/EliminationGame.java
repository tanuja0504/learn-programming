package array;

public class EliminationGame {
    public static int lastRemaining(int n) {
        int increment = 1;
        int start = 1;
        boolean left = true;
        while (n > 1) {
            int temp = n % 2;
            System.out.println(start + " " + left);
            if (left || (temp == 1 && !left)) {
                start = start + increment;
            }
            n = (n / 2);
            left = !left;
            increment = 2 * increment;
        }
        return start;
    }

    public static void main(String[] args) {
        System.out.println(lastRemaining(1000));
    }
}
