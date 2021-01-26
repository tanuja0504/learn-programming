package stack;

import java.util.Iterator;
import java.util.List;

public class FlattenListIterator implements Iterator<Integer> {

    public FlattenListIterator(List<FlattenListIterator> nestedList) {

    }

    @Override
    public Integer next() {
        return 0;
    }

    @Override
    public boolean hasNext() {
        return true;
    }
}
