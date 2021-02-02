package array;

public class MissingNumber {
    public static int missingNumber(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i) {
                i++;
            } else if (nums[i] < nums.length) {
                int temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }
        }
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums[i - 1] + 1;
    }

    public static void main(String[] args) {
        int arr[] = {3, 2, 0};
        System.out.println(missingNumber(arr));
    }
}
