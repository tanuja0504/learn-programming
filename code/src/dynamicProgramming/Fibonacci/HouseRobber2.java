package dynamicProgramming.Fibonacci;

public class HouseRobber2 {
    public static int rob1(int[] nums) {
        int k = nums.length;
        if (k == 0) {
            return 0;
        }
        if (k == 1) {
            return nums[0];
        }
        if (k == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int yes[] = new int[k];
        int no[] = new int[k];
        yes[0] = nums[0];
        no[0] = 0;
        yes[1] = Math.max(nums[1], yes[0]);
        no[1] = nums[1];
        for (int i = 2; i < k; i++) {
            yes[i] = Math.max(yes[i - 2] + nums[i], yes[i - 1]);
            no[i] = Math.max(no[i - 2] + nums[i], no[i - 1]);
            if (i == k - 1) {
                yes[i] = yes[i - 1];
            }
        }
        print(yes);
        print(no);
        return Math.max(yes[k - 1], no[k - 1]);
    }

    public static void print(int[] nums) {
        for (int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 2};
        System.out.println(rob1(nums));
    }
}
