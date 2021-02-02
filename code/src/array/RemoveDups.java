package array;

public class RemoveDups {
    public static int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast = 1;
        while (fast < nums.length) {
            if (nums[fast] > nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow;
    }

    public static int removeDuplicates2(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i - 2])
                nums[i++] = n;
        return i;
    }


    public static void main(String[] args) {
        int arr[] = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        System.out.println("Array " + removeDuplicates2(arr));
        for (int i : arr) {
            System.out.print(i + " ");
        }

    }
}
