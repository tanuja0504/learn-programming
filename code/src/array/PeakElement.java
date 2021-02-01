package array;

import java.util.Stack;

public class PeakElement {
    public static int findPeakElement(int[] nums) {
        Stack<Integer> st = new Stack<>();
        if (nums.length == 1) {
            return nums.length;
        }
        for (int i = 0; i < nums.length; i++) {
            if (st.isEmpty() || st.peek() < nums[i]) {
                st.push(nums[i]);
                System.out.println(st);
            } else if (!st.isEmpty() && st.peek() > nums[i]) {
                return i - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {1, 1, 1, 2};
        System.out.println(findPeakElement(arr));
    }
}
