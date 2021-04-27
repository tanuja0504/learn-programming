package random;

import java.util.Random;

public class ShuffleArray {

    int nums[];
    int rotation = 0;
    Random random;
    int len;

    public ShuffleArray(int[] nums) {
        len = nums.length;
        random = new Random();
        nums = new int[len];
        for (int i = 0; i < nums.length; i++) {
            this.nums[i] = nums[i];
        }
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return nums;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        int rotationBy1 = random.nextInt(len);
        int rotationBy2 = random.nextInt(len);
        int a[] = nums.clone();
        swap(a, rotationBy1, rotationBy2);
        return a;
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4};
        ShuffleArray obj = new ShuffleArray(nums);

        obj.shuffle();
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

}

