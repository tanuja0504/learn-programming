package array;

import java.util.Arrays;
import java.util.Stack;

public class NextPermutation {
    public static void nextPermutation(int[] nums) {
        int end = nums.length - 1;
        int start = 0;
        boolean swap = false;
        Stack<Integer> st = new Stack<>();
        st.push(nums[end]);
        end--;
        while (end >= start) {
            if (!st.isEmpty() && nums[end] < st.peek()) {
                int temp = nums[end];
                nums[end] = st.pop();
                nums[end + 1] = temp;
                swap = true;
            } else {
                st.push(nums[end]);
            }
            end--;
        }
        if (!swap) {
            Arrays.sort(nums);
        }
        System.out.println(st);
    }

    public static void main(String[] args) {
        int arr[] = {1, 3, 2};
        nextPermutation(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
