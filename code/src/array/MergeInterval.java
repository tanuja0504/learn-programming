package array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class MergeInterval {
    public static int[][] merge(int[][] intervals) {
        Stack<Integer> st = new Stack<>();
        Arrays.sort(intervals, Comparator.comparing(o -> o[0]));
        st.push(intervals[0][0]);
        st.push(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            if (st.peek() >= intervals[i][0]) {
                int remove = st.pop();
                if (st.peek() > intervals[i][0] && remove == intervals[i][1]) {
                    st.pop();
                    st.push(intervals[i][0]);
                }
                st.push(Math.max(intervals[i][1], remove));
            } else {
                st.push(intervals[i][0]);
                st.push(intervals[i][1]);
            }
        }
        int result[][] = new int[st.size() / 2][2];
        int i = st.size() / 2;
        while (!st.isEmpty()) {
            i--;
            result[i][1] = st.pop();
            result[i][0] = st.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        int intervals[][] = new int[2][2];
        intervals[0][0] = 1;
        intervals[0][1] = 4;
        intervals[1][0] = 0;
        intervals[1][1] = 4;
        /*intervals[2][0]=8;
        intervals[2][1]=10;
        intervals[3][0]=15;
        intervals[3][1]=18;*/
        int result[][] = merge(intervals);
        System.out.println("Result-->");
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i][0] + " " + result[i][1]);
        }
    }
}
