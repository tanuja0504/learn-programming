package heap;

import java.util.*;

public class SuperUglyNumber {
    public static int nthSuperUglyNumber(int n, int[] primes) {
        Set<Long> candidate = new TreeSet<>();
        List<Integer> visited = new ArrayList<>();
        candidate.add(1L);
        while (!candidate.isEmpty() && visited.size() < n) {
            long t = ((TreeSet<Long>) candidate).pollFirst();
            visited.add((int) t);
            List<Long> temp = generateNthNumber((int) t, primes);
            for (long num : temp) {
                candidate.add(num);
            }
        }
        return visited.get(n - 1);
    }

    public static List<Long> generateNthNumber(int candidate, int[] primes) {
        List<Long> result = new ArrayList<>();
        for (int i : primes) {
            result.add((long) i * candidate);
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = {7, 19, 29, 37, 41, 47, 53, 59, 61, 79, 83, 89, 101, 103, 109, 127, 131, 137, 139, 157, 167, 179, 181, 199, 211, 229, 233, 239, 241, 251};
        System.out.println(nthSuperUglyNumber(10, arr));
    }

}


