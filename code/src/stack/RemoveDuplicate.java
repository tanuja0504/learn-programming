package stack;

import java.util.*;

public class RemoveDuplicate {
    public static String removeDuplicateLetters(String s) {
        if (s.length() == 0) {
            return s;
        }
        Map<Character, Integer> hmap = new HashMap<>();
        Set<Character> outputMap = new HashSet<>();
        char input[] = s.toCharArray();
        for (char c : input) {
            int count = hmap.getOrDefault(c, 0);
            count++;
            hmap.put(c, count);
        }
        Stack<Character> st = new Stack<>();
        st.push(input[0]);
        int update = hmap.get(input[0]) - 1;
        hmap.put(input[0], update);
        outputMap.add(input[0]);
        for (int i = 1; i < input.length; i++) {
            if (st.peek() < input[i] && !outputMap.contains(input[i])) {
                st.push(input[i]);
                int count = hmap.get(input[i]) - 1;
                hmap.put(input[i], count);
                outputMap.add(input[i]);
            } else if (st.peek() > input[i]) {
                if (hmap.get(st.peek()) > 0 && !outputMap.contains(input[i])) {
                    while (!st.isEmpty() && hmap.get(st.peek()) > 0 && !outputMap.contains(input[i])) {
                        char temp = st.pop();
                        outputMap.remove(temp);
                        System.out.println("Removing " + temp + " because of " + input[i]);
                    }
                    st.push(input[i]);
                    int count = hmap.get(input[i]) - 1;
                    hmap.put(input[i], count);
                    outputMap.add(input[i]);
                } else if (!outputMap.contains(input[i])) {
                    st.push(input[i]);
                    int count = hmap.get(input[i]) - 1;
                    hmap.put(input[i], count);
                    outputMap.add(input[i]);
                } else if (outputMap.contains(input[i])) {
                    int count = hmap.get(input[i]) - 1;
                    hmap.put(input[i], count);
                }
            }
            System.out.println("Output Set " + hmap);
            System.out.println("Stack " + st);
        }
        StringBuilder output = new StringBuilder();
        Stack<Character> res = new Stack<>();
        while (!st.isEmpty()) {
            res.push(st.pop());
        }
        while (!res.isEmpty()) {
            output.append(res.pop());
        }
        return output.toString();
    }

    public static void main(String[] args) {
        String s = "bbcaac";
        System.out.println(removeDuplicateLetters(s));
    }
}
