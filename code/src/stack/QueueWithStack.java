package stack;

import java.util.Stack;

public class QueueWithStack {
    Stack<Integer> st;
    Stack<Integer> temp;

    public QueueWithStack() {
        st = new Stack<>();
        temp = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        while (!st.isEmpty()) {
            temp.push(st.pop());
        }
        st.push(x);
        while (!temp.isEmpty()) {
            st.push(temp.pop());
        }
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        return st.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        return st.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return st.isEmpty();
    }
}
