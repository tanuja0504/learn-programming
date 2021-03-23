package BitManipulation;

public class SingleNumber2 {
    public static int singleNumber(int[] nums) {
        int visitedOnce = 0, visitedTwice = 0;
        for (int i : nums) {
            visitedOnce = (visitedOnce ^ i) & ~visitedTwice;
            visitedTwice = (visitedTwice ^ i) & ~visitedOnce;
        }
        return visitedOnce;
    }

    public static void main(String[] args) {
        int nums[] = {2, 2, 3, 2};
        System.out.println(singleNumber(nums));
    }
}
