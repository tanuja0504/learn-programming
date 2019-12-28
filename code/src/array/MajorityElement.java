package array;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int major = -1;
        for (int num : nums) {
            int count = 1;
            if (map.containsKey(num)) {
                count = map.get(num);
                count++;
                map.put(num, count);
            } else {
                map.put(num, count);
            }
            if (count > nums.length / 2) {
                major = num;
            }
        }
        /*for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()>nums.length/2){
                major=entry.getKey();
            }
        }*/
        return major;
    }

    public static void main(String[] args) {
        int arr[] = {2};
        System.out.println(majorityElement(arr));
    }
}
