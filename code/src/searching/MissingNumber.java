package searching;

public class MissingNumber {
    public static int missingNumber(int[] nums) {
        int result = -1;
        int sum = 0;
        int netSum = 0;
        for (int i : nums) {
            sum = sum ^ i;
        }
        for (int i = 0; i <= nums.length; i++) {
            netSum = netSum ^ i;
        }
        result = netSum ^ sum;
        return result;
    }

    public static void main(String[] args) {
        int nums[] = {3, 0, 1};
        MissingNumber obj = new MissingNumber();
        System.out.println(obj.missingNumber(nums));
    }
}
