package string;

import java.util.*;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hmap = new HashMap<>();
        for (String str : strs) {
            char[] input = str.toCharArray();
            Arrays.sort(input);
            String temp = new String(input);
            if (hmap.containsKey(temp)) {
                List<String> list = new ArrayList<>();
                list = hmap.get(temp);
                list.add(str);
                hmap.put(temp, list);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                hmap.put(temp, list);
            }
        }
        List<List<String>> output = new ArrayList<>();
        for (String op : hmap.keySet()) {

            output.add(hmap.get(op));
        }
        return output;
    }

    public static void main(String[] args) {
        String strs[] = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }
}