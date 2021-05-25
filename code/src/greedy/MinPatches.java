package greedy;

public class MinPatches {

    public static int minPatches1(int[] nums, int n) {
        long max = 0;
        int count = 0;
        int i = 0;
        while (max < n) {
            /*max += max + 1 means patching possibly biggest number
            so far(max + 1) to fulfill the purpose of adding minimum patches
            and approaching the n value.*/

            if (i >= nums.length || max < nums[i] - 1) {
                max = max + max + 1;//(Because assume you patched array with max so add max as well
                count++;
            } else {
                max = max + nums[i];
                i++;
            }

        }
        return count;
    }

    public static void main(String[] args) {
        int nums[] = {1, 5, 10};
        System.out.println(minPatches1(nums, 20));

    }
}
