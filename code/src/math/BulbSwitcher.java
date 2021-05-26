package math;

public class BulbSwitcher {
    /*https://leetcode.com/problems/bulb-switcher/discuss/994823/Step-by-Step-Thought-Process*/
    // For prime numbers, they must be off because we can reach them only twice (The first round and their own round).
/* For other numbers, if we can reach them odd times, then they are on; otherwise, they are off. So only
 those numbers who have square root will be reached odd times and there are sqrt(n) of them because
 for every x > sqrt(n), x*x > n and thus should not be considered as the answer. */

    public static int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }

    public static void main(String[] args) {
        System.out.println(bulbSwitch(6));
    }
}
