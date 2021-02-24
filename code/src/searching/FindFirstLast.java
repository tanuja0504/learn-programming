package searching;

public class FindFirstLast {
    public static int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid = -1;
        int result[] = {-1, -1};
        while (start <= end) {
            mid = start + ((end - start) / 2);
            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                if (target == nums[mid]) {
                    int temp = mid;
                    int previous = mid;
                    while (temp >= start && nums[temp] == target) {
                        previous = temp;
                        temp--;
                    }
                    result[0] = previous;
                    temp = mid;
                    while (temp <= end && nums[temp] == target) {
                        previous = temp;
                        temp++;
                    }
                    result[1] = previous;
                    return result;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = {5, 5, 5};
        int target = 5;
        int result[] = searchRange(arr, target);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
