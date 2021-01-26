package stack;

import java.util.*;

public class StackWithQueue {
    Deque<Integer> que;
    Queue<Integer> temp;

    /**
     * Initialize your data structure here.
     */
    public StackWithQueue() {
        que = new ArrayDeque<>();
        temp = new ArrayDeque<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        while (!que.isEmpty()) {
            temp.offer(que.poll());
        }
        que.offer(x);
        while (!temp.isEmpty()) {
            que.offer(temp.poll());
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return que.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return que.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return que.isEmpty();
    }
}
