package tree;

import java.util.*;

interface NestedInteger {
    boolean isInteger();

    Integer getInteger();

    List<NestedInteger> getList();
}

public class FlattenListIterator implements Iterator<Integer> {
    int counter;
    Queue<Integer> q;

    public FlattenListIterator(List<NestedInteger> nestedList) {
        q = new LinkedList<>();
        helper(nestedList);
        counter = q.size();
    }

    public void helper(List<NestedInteger> nestedList) {
        if (nestedList == null) {
            return;
        }
        for (NestedInteger i : nestedList) {
            if (i.isInteger()) {
                q.add(i.getInteger());
            } else {
                helper(i.getList());
            }
        }
    }

    @Override
    public Integer next() {
        counter--;
        return q.poll();
    }

    @Override
    public boolean hasNext() {
        return (counter > 0) ? true : false;
    }
}
