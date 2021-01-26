package stack;

import java.util.Stack;

public class Serialization {
    public boolean isValidSerialization(String preorder) {
        Boolean result = false;
        Stack<Character> st = new Stack<>();
        char input[] = preorder.toCharArray();
        int count[] = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            count[i] = 2;
        }
        st.push(input[0]);
        int trackInput = 1;
        int trackCount = 1;
        while (!st.isEmpty()) {
            if (input[trackInput] != '#') {
                count[trackCount]--;
            }
        }
        for (int i : count) {
            if (count[i] != 0) {
                result = false;
                break;
            }
        }
        return result;
    }
}
