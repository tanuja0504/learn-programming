package design;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Double> max;
    PriorityQueue<Double> min;
    boolean even;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        max = new PriorityQueue<>(Comparator.reverseOrder());
        min = new PriorityQueue<>();
        even = true;
    }

    public void addNum(int num) {
        if (even) {
            min.offer((double) num);
            max.offer(min.poll());
        } else {
            max.offer((double) num);
            min.offer(max.poll());
        }
        even = !even;
    }

    public double findMedian() {
        if (even) {
            return (max.peek() + min.peek()) / 2;
        } else {
            return max.peek();
        }
    }

    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        obj.addNum(1);
        System.out.println(obj.findMedian());
        obj.addNum(2);
        System.out.println(obj.findMedian());
        //obj.addNum(3);
        //System.out.println(obj.findMedian());
    }
}
