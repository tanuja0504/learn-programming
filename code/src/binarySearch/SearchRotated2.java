package binarySearch;

public class SearchRotated2 {
    public static boolean search(int[] nums, int target) {
        /*Look at solution LC# 81*/
        boolean result = false;
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                result = true;
                break;
            }

            if (nums[low] == nums[mid]) {
                //jump for duplicates like [1,0,1,1,1]
                low++;
            } else if (nums[mid] > nums[low]) {
                if (nums[mid] > target && nums[low] <= target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid] < target && nums[high] >= target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int nums[] = {1, 0, 1, 1, 1};
        int target = 0;
        System.out.println(search(nums, target));
    }
}
