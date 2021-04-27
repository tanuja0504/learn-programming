package heap;

import java.util.*;

public class UglyNumberII {
    public static int nthUglyNumber(int n) {
        int primes[] = {2, 3, 5};
        Set<Long> tset = new TreeSet<>();
        List<Long> visited = new ArrayList<>();
        tset.add(1L);
        while (!tset.isEmpty()) {
            if (visited.size() > n) {
                break;
            }
            Long candidate = ((TreeSet<Long>) tset).pollFirst();
            if (!visited.contains(candidate)) {
                visited.add(Long.valueOf(candidate));
                List<Long> temp = getCandidate(candidate, primes);
                for (Long l : temp) {
                    tset.add(l);
                }
            }
        }
        System.out.println(visited);
        return visited.get(n - 1).intValue();
    }

    public static List<Long> getCandidate(Long n, int primes[]) {
        List<Long> t = new ArrayList<>();
        for (int i : primes) {
            t.add(i * n);
        }
        return t;
    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(1690));
    }
}
