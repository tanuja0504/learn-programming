package array;

import java.util.Stack;

public class ShortestUnsortedArray {
    public static int findUnsortedSubarray(int[] nums) {
        int low = nums.length - 1;
        int high = 0;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!st.isEmpty() && nums[st.peek()] > nums[i]) {
                low = Math.min(low, st.pop());
            }
            st.push(i);
        }
        st.clear();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] < nums[i]) {
                high = Math.max(high, st.pop());
            }
            st.push(i);
        }
        return high - low + 1;
    }

    public static void main(String[] args) {
        int nums[] = {1, 3, 5, 4, 2};
        System.out.println(findUnsortedSubarray(nums));
    }
}
