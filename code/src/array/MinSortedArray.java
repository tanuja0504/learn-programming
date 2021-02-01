package array;

public class MinSortedArray {
    public static int findMin(int[] nums) {
        int result = Integer.MAX_VALUE;
        int start = 0;
        int end = nums.length - 1;
        int temp = result;
        while (start <= end) {
            int mid = -1;
            if (nums[start] != nums[end]) {
                mid = (start + end) / 2;
            } else {
                while (start < end && nums[start] == nums[end]) {
                    start++;
                }
                mid = (start + end) / 2;
            }
            temp = nums[mid];
            result = Math.min(result, temp);
            if (start == end) {
                break;
            }

            if (nums[mid] <= nums[mid + 1] && nums[mid] <= nums[end]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }

        return result;
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 1};
        System.out.println(findMin(nums));
    }
}
