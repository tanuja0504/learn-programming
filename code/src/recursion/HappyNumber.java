package recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HappyNumber {
    Set<Integer> set = new HashSet<Integer>();

    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        } else if (set.contains(n)) {
            return false;
        } else {
            set.add(n);
            int output = 0;
            while (n > 0) {
                int m = n % 10;
                n = n / 10;
                output = m * m + output;
            }
            n = output;
            System.out.println(output);
        }

        return isHappy(n);
    }

    public boolean isHappy1(int n) {
        boolean flag = true;
        Set<Integer> set1 = new HashSet<Integer>();
        while (flag && n != 1) {
            List<Integer> list = new ArrayList<>();
            while (n > 0) {
                int m = n % 10;
                n = n / 10;
                m = m * m;
                list.add(m);
            }
            for (int temp : list) {
                n = n + temp;
            }
            System.out.println(n);
            if (set1.contains(n)) {
                flag = false;
            } else {
                set1.add(n);
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        HappyNumber obj = new HappyNumber();
        System.out.println(obj.isHappy(2));
    }
}