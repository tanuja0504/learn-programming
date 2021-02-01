package array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        int result[] = {-1, -1};
        for (int i = 0; i < numbers.length; i++) {

            if (map.containsKey(numbers[i])) {
                result[1] = i + 1;
                result[0] = map.get(numbers[i]) + 1;
            }
            map.put(target - numbers[i], i);
        }
        return result;
    }

}
