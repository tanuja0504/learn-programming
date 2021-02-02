package array;

public class FirstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        if (nums.length == 0) return 1;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] <= 0 || nums[i] > nums.length) {
                i++;
                continue;
            } else if (nums[i] == nums[nums[i] - 1]) {
                i++;
            } else {
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }
        // finding the smallest positive element out of its position

        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) return i + 1;
        }

        return nums[i - 1] + 1;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 0};
        System.out.println(firstMissingPositive(arr));
    }
}
