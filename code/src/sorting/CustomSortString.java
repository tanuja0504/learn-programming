package sorting;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class CustomSortString {

    Map<Character, Integer> hmap;

    public class CustomComparator implements Comparator<Character> {

        @Override
        public int compare(Character o1, Character o2) {
            return Integer.compare(hmap.get(o1), hmap.get(o2));
        }
    }

    public String customSortString(String order, String str) {
        StringBuilder sb = new StringBuilder();
        hmap = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            hmap.put(order.charAt(i), i);
        }
        for (int i = 0; i < str.length(); i++) {
            if (!hmap.containsKey(str.charAt(i))) {
                hmap.put(str.charAt(i), order.length());
            }
        }
        PriorityQueue<Character> pq = new PriorityQueue<>(new CustomComparator());
        for (int i = 0; i < str.length(); i++) {
            pq.offer(str.charAt(i));
        }
        while (!pq.isEmpty()) {
            sb.append(pq.poll());
        }
        return sb.toString();
    }

    /*Use bucket sort to achieve linear time.
    Put string T into bucket;
    Scan each character of S and construct the result string using bucket;
    Scan bucket again to append the rest of characters which are not existing in string S.
    */
    public String customSortString1(String order, String str) {

        StringBuilder sb = new StringBuilder();
        int bucket[] = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            bucket[c - 'a']++;
        }
        for (int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            while (bucket[c - 'a'] > 0) {
                sb.append(c);
                bucket[c - 'a']--;
            }
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            while (bucket[c - 'a'] > 0) {
                sb.append(c);
                bucket[c - 'a']--;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String order = "cba";
        String str = "abcd";
        CustomSortString obj = new CustomSortString();
        System.out.println(obj.customSortString1(order, str));
    }
}
