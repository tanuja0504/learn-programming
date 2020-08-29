package recursion;

/*Find sum of n natural numbers*/

public class SumOfN {
    public int sumNatural(int n) {
        if (n <= 0) {
            return 0;
        }
        return n + sumNatural(n - 1);
    }

    public int sumNaturalLoop(int n) {
        int result = 0;
        for (int i = 0; i < n + 1; i++) {
            result = result + i;
        }
        return result;
    }

    public static void main(String[] args) {
        SumOfN obj = new SumOfN();
        System.out.println(obj.sumNaturalLoop(9));
    }
}
