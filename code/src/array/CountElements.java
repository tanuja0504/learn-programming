package array;

import java.util.HashMap;
import java.util.Map;

public class CountElements {
    public static int countElements(int[] arr) {
        int output = 0;
        Map<Integer, Map<Integer, Integer>> hmap = new HashMap<>();
        for (int a : arr) {
            if (hmap.containsKey(a)) {
                Integer repeat = (Integer) hmap.get(a).keySet().toArray()[0] + 1;
                Map<Integer, Integer> val = new HashMap<>();
                val.put(repeat, 0);
                hmap.put(a, val);
            } else {
                int repeat = 1;
                Map<Integer, Integer> val = new HashMap<>();
                val.put(repeat, 0);
                hmap.put(a, val);
            }

        }
        System.out.println(hmap);
        for (int a : arr) {
            if (hmap.containsKey(a + 1)) {
                Integer repeat = (Integer) hmap.get(a).keySet().toArray()[0];
                Integer count = hmap.get(a).get(repeat) + 1;
                //count=repeat*count;
                Map<Integer, Integer> val = new HashMap<>();
                val.put(repeat, count);
                hmap.put(a, val);
            }
        }

        for (Map.Entry<Integer, Map<Integer, Integer>> entry : hmap.entrySet()) {
            Map<Integer, Integer> childMap = entry.getValue();

            for (int a : childMap.values()) {
                if (a > 0) {
                    output = output + a;
                }
            }
        }

        System.out.println(hmap);

        return output;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3};
        System.out.println(countElements(arr));
    }
}
