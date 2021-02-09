package array;

public class ContainerWater {
    public static int maxArea(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int result = Integer.MIN_VALUE;
        int begin = 0, end = height.length - 1;
        int output[] = new int[height.length];
        int i = 0;
        while (begin < end) {
            if (height[begin] <= height[end]) {
                output[i] = (end - begin) * Math.min(height[begin], height[end]);
                begin++;
                i++;
            }
            if (height[begin] > height[end]) {
                output[i] = (end - begin) * Math.min(height[begin], height[end]);
                end--;
                i++;
            }
        }
        for (int j : output) {
            //System.out.println(j);
            result = Math.max(result, j);
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 1};
        int arr1[] = {1, 1};
        System.out.println(maxArea(arr));
    }
}
