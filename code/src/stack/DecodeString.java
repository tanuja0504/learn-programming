package stack;

import java.util.Stack;

public class DecodeString {
    public static String decodeString(String s) {
        Stack<String> st = new Stack<>();
        StringBuilder original = new StringBuilder();

        char input[] = s.toCharArray();
        for (char c : input) {
            StringBuilder temp = new StringBuilder();
            if (c == ']') {
                while (!st.peek().equals("[")) {
                    temp.insert(0, st.pop());
                }
                st.pop();
                if (!st.isEmpty() && st.peek().matches("-?\\d+")) {
                    StringBuilder tempVal = new StringBuilder();
                    while (!st.isEmpty() && st.peek().matches("-?\\d+")) {
                        tempVal.insert(0, st.pop());
                    }
                    int loopVal = Integer.parseInt(tempVal.toString());
                    System.out.println(tempVal);
                    StringBuilder tempInsert = new StringBuilder();
                    for (int i = 0; i < loopVal; i++) {
                        tempInsert.insert(0, temp);
                    }
                    st.push(tempInsert.toString());
                }
            } else {
                st.push(Character.toString(c));
            }
        }
        //System.out.println(st);
        while (!st.isEmpty()) {
            original.insert(0, st.pop());
        }

        return original.toString();
    }

    public static void main(String[] args) {
        System.out.println(decodeString("100[leetcode]"));
    }
}
