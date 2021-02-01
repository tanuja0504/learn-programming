package array;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int[] toAdd = newInterval;
        for (int i = 0; i < intervals.length; i++) {
            /*1. No overlap and toAdd appears before current interval, add toAdd to result.*/
            if (intervals[i][0] > toAdd[1]) {
                ans.add(toAdd);
                toAdd = intervals[i];
            }/*2. Has overlap, update the toAdd to the merged interval.*/ else if (intervals[i][1] >= toAdd[0]) {
                toAdd = new int[]
                        {Math.min(intervals[i][0], toAdd[0]),
                                Math.max(intervals[i][1], toAdd[1])};
            }/*3. No overlap and toAdd appears after current interval, add current interval to result.*/ else {
                ans.add(intervals[i]);
            }
        }
        ans.add(toAdd);
        return ans.toArray(new int[ans.size()][2]);
    }

    public static void main(String[] args) {
        int intervals[][] = new int[2][2];
        intervals[0][0] = 1;
        intervals[0][1] = 2;
        intervals[1][0] = 3;
        intervals[1][1] = 4;
        /*intervals[2][0]=8;
        intervals[2][1]=10;
        intervals[3][0]=15;
        intervals[3][1]=18;*/
        int insert[] = {1, 4};
        int result[][] = insert(intervals, insert);
        System.out.println("Result-->");
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i][0] + " " + result[i][1]);
        }
    }
}
