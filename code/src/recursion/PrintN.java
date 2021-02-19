package recursion;

public class PrintN {
    public void printN(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        printN(n - 1);
        System.out.println(n);

    }

    public static void main(String[] args) {
        PrintN obj = new PrintN();
        obj.printN(7);
    }
}
