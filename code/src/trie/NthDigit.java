package trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NthDigit {
    public static int findNthDigit(int n) {
        if (n < 9) {
            return n;
        }
        List<Long> num = new ArrayList<>();
        long i = 0;
        long temp = 1;
        long finalVal = 0;
        num.add(0L);
        while (temp * i < n) {
            temp = 9 * (int) Math.pow(10, i);
            num.add(temp);
            i++;
        }
        long result = 0;
        for (int k = 0; k < i; k++) {
            result = result + num.get(k);
            n = (int) (n - (num.get(k) * k));
        }
        System.out.println(num);
        long modValue = n % i;
        n = n / (int) i;
        result = result + n;


        if (modValue % i == 0) {
            List<Integer> r = digits((int) result);
            finalVal = r.get(r.size() - 1);
        } else {
            result++;
            List<Integer> r = digits((int) result);
            System.out.println(r + " " + modValue + " " + i + " " + r.size());
            System.out.println(result % Math.pow(10, i - modValue + 1));
            finalVal = r.get((int) (modValue - 1));
        }
        return (int) finalVal;
    }

    public static List<Integer> digits(int d) {
        List<Integer> list = new ArrayList<>();
        while (d > 0) {
            list.add(d % 10);
            d = d / 10;
        }
        Collections.reverse(list);
        return list;
    }

    public static void main(String[] args) {
        System.out.println(16);
        System.out.println(findNthDigit(2147483647));
    }
}
