package dynamicProgramming.Fibonacci;

import java.util.ArrayList;
import java.util.List;

public class UglyNumber2 {
    public static int nthUglyNumber(int n) {
        //Index is actual number and element is term count
        List<Boolean> dp = new ArrayList<>();
        dp.add(0, false);
        dp.add(1, true);
        dp.add(2, true);
        dp.add(3, true);
        dp.add(4, true);
        dp.add(5, true);
        if (n <= 5) {
            return n;
        }
        int term = 6;
        int num = 6;

        return dp.size() - 1;
    }


    public static void main(String[] args) {
        System.out.println(nthUglyNumber(1250));
    }
}
