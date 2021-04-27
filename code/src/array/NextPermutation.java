package array;

public class NextPermutation {
    /*
    Idea:
    1. Reverse find first number which breaks descending order.
    2. Exchange this number with the least number that's greater than this number.
    3. Reverse sort the numbers after the exchanged number. Because we want it in increasing sequence
*/
    public static void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        if (nums.length == 2) {
            swap(nums, 0, 1);
            return;
        }
        int decIndex = nums.length - 2;
        while (decIndex >= 0) {
            if (nums[decIndex] < nums[decIndex + 1]) {
                break;
            }
            decIndex--;
        }
        if (decIndex >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[decIndex]) {
                j--;
            }
            swap(nums, decIndex, j);
        }
        reverseSort(nums, decIndex + 1, nums.length - 1);
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void reverseSort(int[] num, int start, int end) {
        System.out.println("Reversing " + start + " " + end);
        while (start < end) {
            swap(num, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int arr[] = {5, 1, 1};
        int arr1[] = {1, 9, 8, 7, 5};
        nextPermutation(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
