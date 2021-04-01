package heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KPair {
    class Data {
        int i;
        int j;
        int sum;

        public Data(int i, int j, int sum) {
            this.i = i;
            this.j = j;
            this.sum = sum;
        }
    }

    class Comparator1 implements Comparator<Data> {

        @Override
        public int compare(Data o1, Data o2) {
            if (o1.sum == o2.sum) {
                return 0;
            } else if (o1.sum < o2.sum) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<Data> pq = new PriorityQueue<>(new Comparator1());
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                Data d = new Data(nums1[i], nums2[j], nums1[i] + nums2[j]);
                pq.offer(d);
            }
        }
        int size = pq.size();
        for (int i = 0; i < size; i++) {
            System.out.println(pq.size());
            Data d = pq.poll();
            List<Integer> l = new ArrayList<>();
            l.add(d.i);
            l.add(d.j);
            result.add(l);
            if (result.size() == k) {
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int nums1[] = {1, 2};
        int nums2[] = {3};
        KPair obj = new KPair();
        System.out.println(obj.kSmallestPairs(nums1, nums2, 3));
    }
}
