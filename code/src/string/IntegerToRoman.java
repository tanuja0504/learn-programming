package string;

import java.util.Map;
import java.util.TreeMap;

public class IntegerToRoman {

    public static String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        Map<Integer, String> map = new TreeMap<>();
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");
        map.put(4, "IV");
        map.put(9, "IX");
        map.put(40, "XL");
        map.put(90, "XC");
        map.put(400, "CD");
        map.put(900, "CM");

        //The floorEntry(K key) method is used to return a key-value
        // mapping associated with the greatest key less than or equal to the given key,
        // or null if there is no such key.
        while (num != 0) {
            Map.Entry<Integer, String> e = ((TreeMap<Integer, String>) map).floorEntry(num);
            result.append(e.getValue());
            num = num - e.getKey();
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
    }
}
