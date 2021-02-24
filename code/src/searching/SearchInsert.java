package searching;

public class SearchInsert {
    public static int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid = -1;
        while (end >= start) {
            mid = start + ((end - start) / 2);
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        if (start < end && target < nums[start]) {
            mid = start - 1;
        } else if (target > nums[end]) {
            mid = end + 1;
        } else {
            mid = start;
        }

        return mid;
    }

    public static void main(String[] args) {
        int arr[] = {1, 3, 5, 6};
        int target = 0;
        System.out.println(searchInsert(arr, target));
    }
}
