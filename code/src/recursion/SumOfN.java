package recursion;

/*Find sum of n natural numbers*/

public class SumOfN {
    public int sumNatural(int n) {
        if (n <= 0) {
            return 0;
        }
        return n + sumNatural(n - 1);
    }

    public static void main(String[] args) {
        SumOfN obj = new SumOfN();
        System.out.println(obj.sumNatural(9));
    }
}
