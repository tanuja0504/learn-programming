package queue;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SlidingWindow {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<Integer> result = new ArrayList<>();
        int start = 0;
        int end = start + 3;
        if (k == 1) {
            return nums;
        }
        while (end < nums.length) {
            while (start < end) {
                pq.add(nums[start]);
                start++;
            }

            end++;
        }
        System.out.println(pq);
        int output[] = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            output[i] = result.get(i);
        }
        return output;
    }

    public static void main(String[] args) {
        int nums[] = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int result[] = maxSlidingWindow(nums, k);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
