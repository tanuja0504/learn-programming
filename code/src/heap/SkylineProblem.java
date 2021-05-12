package heap;

import java.util.*;


class SkylineProblem {
    public static List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();
        int m = buildings.length;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            //Adding negative to indicate start of coordinate
            int startTuple[] = new int[2];
            startTuple[0] = buildings[i][0];
            startTuple[1] = buildings[i][2] * -1;

            int endTuple[] = new int[2];
            endTuple[0] = buildings[i][1];
            endTuple[1] = buildings[i][2];

            list.add(startTuple);
            list.add(endTuple);
        }

        // sort $height, based on the first value, if necessary, use the second to
        // break ties
        Collections.sort(list, (a, b) ->
        {
            if (a[0] != b[0])
                return a[0] - b[0];
            else
                return a[1] - b[1];
        });

        Map<Integer, Integer> tmap = new TreeMap<>(Comparator.reverseOrder());
        tmap.putIfAbsent(0, 0);
        int previous = 0;
        for (int[] h : list) {
            int t = h[1];
            if (t > 0) {
                tmap.remove(t);
            } else {
                t = t * -1;
                tmap.putIfAbsent(t, 0);
            }
            int height = ((TreeMap<Integer, Integer>) tmap).firstKey();
            if (previous != height) {
                List<Integer> temp = new ArrayList<>();
                temp.add(h[0]);
                temp.add(height);
                result.add(temp);
                previous = height;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int nums[][] = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        int nums1[][] = {{0, 2, 3}, {2, 5, 3}};
        System.out.println(getSkyline(nums1));
    }
}
