package dynamicProgramming.Fibonacci;

public class BuyAndSellStock3 {
    /*https://www.youtube.com/watch?v=wuzTpONbd-0 */
    public static int maxProfit(int[] prices) {
        int n = prices.length;

        int leastInLeft = prices[0];
        int dpMaxProfitLeft[] = new int[n];
        dpMaxProfitLeft[0] = 0;
        for (int i = 1; i < n; i++) {
            if (prices[i] < leastInLeft) {
                leastInLeft = prices[i];
            }
            int profitToday = prices[i] - leastInLeft;
            dpMaxProfitLeft[i] = Math.max(profitToday, dpMaxProfitLeft[i - 1]);
        }

        int maxInRight = prices[n - 1];
        int dpMaxProfitRight[] = new int[n];
        dpMaxProfitRight[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (maxInRight < prices[i]) {
                maxInRight = prices[i];
            }
            int profitToday = maxInRight - prices[i];
            dpMaxProfitRight[i] = Math.max(dpMaxProfitRight[i + 1], profitToday);
        }

        int everyDayNonOverLappingProfit[] = new int[n];
        int result = 0;
        for (int i = 0; i < n; i++) {
            everyDayNonOverLappingProfit[i] = dpMaxProfitLeft[i] + dpMaxProfitRight[i];
            result = Math.max(result, everyDayNonOverLappingProfit[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int nums[] = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(maxProfit(nums));
    }
}
