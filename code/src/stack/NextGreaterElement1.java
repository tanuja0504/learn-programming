package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement1 {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> hmap = new HashMap<>();
        int result[] = new int[nums1.length];
        Stack<Integer> st = new Stack<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            int top = -1;
            while (!st.isEmpty() && st.peek() < nums2[i]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                top = st.peek();
            }
            hmap.put(nums2[i], top);
            st.push(nums2[i]);
            System.out.println(st);
        }
        int start = 0;
        for (int i : nums1) {
            result[start] = hmap.get(i);
            start++;
        }

        return result;
    }

    public static void main(String[] args) {
        int nums1[] = {4, 1, 2};
        int nums2[] = {1, 3, 4, 2};
        System.out.println("Value " + nextGreaterElement(nums1, nums2));
    }
}
