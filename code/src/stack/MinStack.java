package stack;

import java.util.Stack;

public class MinStack {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public MinStack() {

    }

    public void push(int x) {
        s1.push(x);
        if (s2.isEmpty() || s2.peek() > x) {
            s2.push(x);
        } else {
            s2.push(s2.peek());
        }
    }

    public void pop() {
        s1.pop();
        s2.pop();
    }

    public int top() {
        return s1.peek();
    }

    public int getMin() {
        return s2.peek();
    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        int x = -3;
        obj.push(x);
        obj.pop();
        int param_3 = obj.top();
        int param_4 = obj.getMin();
        System.out.println(param_3 + " " + param_4);
    }
}
