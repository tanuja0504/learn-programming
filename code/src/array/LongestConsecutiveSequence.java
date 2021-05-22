package array;

import java.util.*;

public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {
        Set<Integer> visited = new HashSet<>();
        int maxLen = 0;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        System.out.println(System.nanoTime());
        for (int i : nums) {
            if (!graph.containsKey(i)) {
                graph.put(i, new ArrayList<>());
                graph.get(i).add(i + 1);
                graph.get(i).add(i - 1);
            }
        }
        System.out.println(System.nanoTime());
        for (int i : nums) {
            if (visited.contains(i)) {
                continue;
            }
            int path = helperDFS(i, visited, graph);
            maxLen = Math.max(path, maxLen);
        }
        System.out.println(System.nanoTime());
        return maxLen;
    }

    public static int helperDFS(int element, Set<Integer> visited, Map<Integer, List<Integer>> graph) {
        Stack<Integer> st = new Stack<>();
        int result = 0;
        st.push(element);
        while (!st.isEmpty()) {
            int a = st.pop();
            visited.add(a);
            result++;
            List<Integer> temp = graph.get(a);
            for (int i : temp) {
                if (graph.containsKey(i) && !visited.contains(i)) {
                    st.push(i);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int nums[] = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }
}
