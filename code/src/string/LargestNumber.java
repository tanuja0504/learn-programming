package string;

import java.util.Arrays;
import java.util.Comparator;

class LargestComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        String s1 = o1 + o2;
        String s2 = o2 + o1;
        return o1.compareTo(o2);
    }
}

public class LargestNumber {
    public static String largestNumber(int[] nums) {
        String numbers[] = new String[nums.length];
        int j = 0;
        for (int i : nums) {
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            numbers[j] = sb.toString();
            j++;
        }
        Arrays.sort(numbers, new LargestComparator());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            sb.append(numbers[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int nums[] = {3, 30, 34, 5, 9};
        System.out.println(largestNumber(nums));
    }
}
