package dynamicProgramming.LIS;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FrogJump {
    public static boolean canCross(int[] stones) {
        int n = stones.length;
        Map<Integer, Set<Integer>> dp = new HashMap<>();

        for (int stone : stones) {
            dp.put(stone, new HashSet<>());
        }
        //Adding base case ,mentioned in question
        //Also input is sorted
        dp.get(0).add(1);
        for (int stone : stones) {
            for (int jump : dp.get(stone)) {
                //Reachable stone will be added if present in input
                int reachable = stone + jump;
                if (jump != 0 && dp.containsKey(reachable)) {
                    dp.get(reachable).add(jump - 1);
                    dp.get(reachable).add(jump);
                    dp.get(reachable).add(jump + 1);
                }
            }
        }

        return !dp.get(stones[n - 1]).isEmpty();
    }

    public static void main(String[] args) {
        int nums[] = {0, 1, 3, 5, 6, 8, 12, 17};
        System.out.println(canCross(nums));
    }
}
