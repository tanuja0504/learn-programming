package stack;

import java.util.Stack;

public class DailyTemperatures {
    static class tuple {
        int index = -1;
        int value = 0;

        tuple(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int result[] = new int[temperatures.length];
        Stack<tuple> st = new Stack<>();
        for (int i = temperatures.length - 1; i >= 0; i--) {
            int top = 0;
            while (!st.isEmpty() && st.peek().value <= temperatures[i]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                top = st.peek().index - i;
            }
            result[i] = top;
            st.push(new tuple(temperatures[i], i));
        }
        return result;
    }

    public static void main(String[] args) {
        int temps[] = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(dailyTemperatures(temps));
    }
}
