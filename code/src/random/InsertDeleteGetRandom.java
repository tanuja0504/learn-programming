package random;

import java.util.*;

public class InsertDeleteGetRandom {

    Map<Integer, Set<Integer>> hmap;
    List<Integer> list;
    Random random;

    /**
     * Initialize your data structure here.
     */
    public InsertDeleteGetRandom() {
        hmap = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        boolean result = false;
        list.add(val);
        if (!hmap.containsKey(val)) {
            hmap.put(val, new HashSet<>());
            result = true;
        }
        hmap.get(val).add(list.size() - 1);
        return result;
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {

        boolean result = false;
        if (hmap.containsKey(val)) {
            result = true;
            int removeIndex = hmap.get(val).iterator().next();
            System.out.println(hmap);
            hmap.get(val).remove(removeIndex);
            if (hmap.get(val).size() == 0) {
                hmap.remove(val);
            }
            if (list.size() > 1) {
                int lastElement = list.get(list.size() - 1);
                list.set(removeIndex, lastElement);
                list.remove(list.size() - 1);
                if (hmap.containsKey(lastElement)) {
                    hmap.get(lastElement).remove(list.size());
                    hmap.get(lastElement).add(removeIndex);
                }
            } else {
                list.clear();
            }
            //System.out.println(hmap);
        }
        return result;
    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        int temp = random.nextInt(list.size());
        return list.get(temp);
    }


    public static void main(String[] args) {
        InsertDeleteGetRandom obj = new InsertDeleteGetRandom();
        obj.insert(1);
        obj.insert(1);
        obj.insert(2);
        obj.insert(1);
        obj.insert(2);
        obj.insert(2);
        obj.remove(1);
        obj.remove(2);
        obj.remove(2);
        obj.remove(2);
        System.out.println(obj.hmap);
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
    }
}
