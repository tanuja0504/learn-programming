package design;

import java.util.*;

/*The List is used to store numbers and serve the getRandom() method.
The Map contains the mapping between the value and its index in the ArrayList.
The Map helps to check whether a value is already inserted or not.
The main trick is when you remove a value.
ArrayList's remove method is O(n) if you remove from random location.
To overcome that, we swap the values between (randomIndex, lastIndex) and always remove the entry from the end of the list.
After the swap, you need to update the new index of the swapped value (which was previously at the end of the list) in the map.
*/

public class RandomizedSet {
    List<Integer> list;
    Map<Integer, Integer> hmap;
    Random random;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        list = new ArrayList<>();
        hmap = new HashMap<>();
        random = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (hmap.containsKey(val)) {
            return false;
        }
        list.add(val);
        hmap.put(val, list.size());
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!hmap.containsKey(val)) {
            return false;
        }
        int i;
        for (i = 0; i < list.size(); i++) {
            if (list.get(val) == i) {
                break;
            }
        }
        swap(list, i, list.size() - 1);
        return true;
    }

    public void swap(List<Integer> list, int i, int j) {
        int t1 = list.get(i);
        int t2 = list.get(j);
        list.set(i, t2);
        list.set(j, t1);
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        int index = random.nextInt(list.size());
        return list.get(index);
    }

    public static void main(String[] args) {
        RandomizedSet obj = new RandomizedSet();
        obj.insert(1);
        obj.insert(10);
        obj.insert(20);
        obj.insert(30);
        for (int i = 0; i < 10; i++) {
            System.out.println(obj.getRandom());
        }
    }
}
