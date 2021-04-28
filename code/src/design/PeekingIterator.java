package design;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class PeekingIterator implements Iterator<Integer> {
    List<Integer> nums;
    int current;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        nums = new ArrayList<>();
        while (iterator.hasNext()) {
            nums.add(iterator.next());
        }
        current = 0;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        int result = nums.get(current);
        return result;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        int result = nums.get(current);
        current++;
        return result;
    }

    @Override
    public boolean hasNext() {
        return (current < nums.size()) ? true : false;
    }

    public static void main(String[] args) {

    }
}
