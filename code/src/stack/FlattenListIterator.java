package stack;

import java.util.ArrayList;
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

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> one = new ArrayList<>();
        one.add(1);
        one.add(1);
        List<Integer> two = new ArrayList<>();
        one.add(2);
        list.add(two);
        List<Integer> three = new ArrayList<>();
        three.add(1);
        three.add(1);
        list.add(one);
        list.add(two);
        list.add(three);

    }
}
