package array;

import java.util.ArrayList;
import java.util.List;

public class CountPrimeNumber {
    public static int countPrimes(int n) {
        List<Integer> result = new ArrayList<>();
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        result.add(2);
        result.add(3);
        boolean flagPrime = false;
        for (int i = 4; i < n; i++) {
            for (int num : result) {
                if (i % num == 0) {
                    flagPrime = false;
                    break;
                } else {
                    flagPrime = true;
                }
            }
            if (flagPrime) {
                result.add(i);
            }
        }
        System.out.println(result);
        return result.size();
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(499979));
    }
}
