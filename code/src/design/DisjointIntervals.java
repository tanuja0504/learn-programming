package design;

import java.util.TreeMap;

public class DisjointIntervals {
    /**
     * Initialize your data structure here.
     */
    TreeMap<Integer, Integer> m;

    public DisjointIntervals() {
        m = new TreeMap<>();
    }

    public void addNum(int val) {
        Integer floor = m.floorKey(val);
        if (floor == null || floor + m.get(floor) + 1 < val) {
            m.put(val, 0);
            floor = val;
        } else if (floor + m.get(floor) + 1 == val) {
            m.put(floor, m.get(floor) + 1);
        }

        Integer ceiling = m.ceilingKey(val + 1);
        if (ceiling != null && ceiling - 1 == val) {
            m.put(floor, m.get(floor) + m.get(ceiling) + 1);
            m.remove(ceiling);
        }
    }

    public int[][] getIntervals() {
        return m.entrySet().stream()
                .map(e -> new int[]{e.getKey(), e.getKey() + e.getValue()})
                .toArray(int[][]::new);
    }
}
