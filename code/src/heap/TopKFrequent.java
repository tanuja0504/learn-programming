package heap;

import java.util.*;


public class TopKFrequent {
    public static int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : nums) {
            map.put(new Integer(a), new Integer(map.getOrDefault(a, 0) + 1));
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            pq.add(e);
        }
        int count = 0;
        while (k > 0 && !pq.isEmpty()) {
            result[count] = pq.peek().getKey();
            count++;
            pq.poll();
            k--;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 1, 2, 2, 3};
        System.out.println(topKFrequent(a, 2));
    }
}
