package binarySearch;

public class SearchRotatedArray {
    public static int search(int[] nums, int target) {
        int result = -1;
        int low = 0;
        int high = nums.length - 1;
        int mid = low + high / 2;
        while (low <= mid && mid <= high) {
            mid = low + high / 2;
            if (nums[mid] == target) {
                result = mid;
            } else if (nums[mid - 1] < nums[mid] && target < nums[mid]) {
                high = mid;
            } else if (nums[mid + 1] > nums[mid] && target > nums[mid]) {
                low = mid;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(search(arr, 4));
    }
}
