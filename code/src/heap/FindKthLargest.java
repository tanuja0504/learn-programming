package heap;

import java.util.PriorityQueue;

public class FindKthLargest {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            System.out.println(pq);
            pq.offer(nums[i]);
            if (pq.size() > k) {
                while (pq.size() > k) {
                    int t = pq.poll();
                }
            }
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        int nums[] = {3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(nums, 2));
    }
}
