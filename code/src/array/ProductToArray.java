package array;

public class ProductToArray {
    public static int[] productExceptSelf(int[] nums) {
        int result[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = 1;
        }
        int tmp = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = tmp;
            tmp = tmp * nums[i];
        }
        tmp = 1;
        for (int i = nums.length - 1; i > -1; i--) {
            result[i] = tmp;
            tmp = tmp * nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = {2, 1, 4, 3};
        int result[] = productExceptSelf(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
