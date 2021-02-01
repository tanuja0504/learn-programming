package array;

public class SearchRotated2 {
    public static boolean search(int[] nums, int target) {
        boolean result = false;
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                result = true;
                break;
            }

            if (nums[low] < nums[high] && nums[mid] < target) {
                high = mid - 1;
            } else if (nums[low] < nums[high] && nums[mid] > target) {
                low = mid + 1;
            } else if (nums[low] > nums[high] && nums[mid] > target) {
                high = mid - 1;
            } else if (nums[low] > nums[high] && nums[mid] < target) {
                low = mid + 1;
            } else if (nums[low] == nums[high]) {
                if (nums[mid] < nums[mid + 1] && target < nums[mid]) {
                    high--;
                } else if (nums[mid] > nums[mid - 1] && target > nums[mid]) {
                    low++;
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
