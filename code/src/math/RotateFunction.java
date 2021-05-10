package math;

public class RotateFunction {
    public static int maxRotateFunction(int[] A) {
        int n = A.length;
        int sum = 0;
        int max = Integer.MAX_VALUE;
        int sumSoFar = 0;

        for (int i = 0; i < n; i++) {
            sumSoFar = sumSoFar + A[i];
            sum = sum + (A[i] * i);
        }
        System.out.println(sum);
        max = Math.max(sum, max);
        for (int i = n - 1; i > 0; i--) {
            sum = sum - (A[i] * n) + sumSoFar;
            max = Math.max(sum, max);
        }

        return max;
    }

    public static void main(String[] args) {
        int nums[] = {4, 3, 2, 6};
        int nums1[] = {0, 1, 720000000};
        System.out.println(maxRotateFunction(nums1));
    }
}
