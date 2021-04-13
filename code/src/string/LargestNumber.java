package string;

import java.util.Arrays;
import java.util.Comparator;

class LargestComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        String s1 = o1 + o2;
        String s2 = o2 + o1;
        return s2.compareTo(s1);
    }
}

public class LargestNumber {
    public static String largestNumber(int[] nums) {
        String numbers[] = new String[nums.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numbers, new LargestComparator());
        if (numbers[0].equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String s : numbers) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int nums[] = {3, 30, 34, 5, 9};
        System.out.println(largestNumber(nums));
    }
}
