package bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WaterAndJug {
    public static boolean canMeasureWater(int x, int y, int z) {

        int maxCapacity = x + y;
        if (z > maxCapacity) {
            return false;
        }
        Queue<Integer> states = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        states.add(0);
        while (!states.isEmpty()) {
            int t = states.poll();
            if (!visited.contains(t)) {
                visited.add(t);
                isValidState(states, t + x, maxCapacity);
                isValidState(states, t - x, maxCapacity);
                isValidState(states, t + y, maxCapacity);
                isValidState(states, t - y, maxCapacity);
            }

            if (visited.contains(z)) {
                return true;
            }
        }

        return false;
    }

    public static void isValidState(Queue<Integer> states, int value, int maxCapacity) {
        if (value <= maxCapacity && value >= 0) {
            states.add(value);
        }
    }

    public static void main(String[] args) {
        System.out.println(canMeasureWater(3, 5, 4));
    }
}
