package greedy;

public class GasStation {
    /*The algorithm is pretty easy to understand.
    Imagine we take a tour around this circle, the only condition that
    we can complete this trip is to have more fuel provided than costed in total.
    That's what the first loop does.

    If we do have more fuel provided than costed,
    that means we can always find a start point around this circle that we could
    complete the journey with an empty tank.
    Hence, we check from the beginning of the array,
    if we can gain more fuel at the current station,
    we will maintain the start point, else,
    which means we will burn out of oil before reaching to the next station,
    we will start over at the next station.*/

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas = gas[i] - cost[i] + totalGas;
        }
        System.out.println(totalGas);
        if (totalGas < 0) {
            return -1;
        }
        int accumulated = 0;
        for (int i = 0; i < gas.length; i++) {
            int current = gas[i] - cost[i];
            if (accumulated + current < 0) {
                start = i + 1;
                accumulated = 0;
            } else {
                accumulated = accumulated + gas[i] - cost[i];
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int gas[] = {2, 3, 4};
        int cost[] = {3, 4, 3};
        System.out.println(canCompleteCircuit(gas, cost));
    }
}
