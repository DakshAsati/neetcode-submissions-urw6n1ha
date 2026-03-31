class Solution {
    public int maxProfit(int[] prices) {
        return helper(prices, 0, false);
    }

    public int helper(int[] prices, int i, boolean holding) {
        if (i >= prices.length) return 0;

        if (holding) {
            // Option 1: sell today → cooldown next day
            int sell = prices[i] + helper(prices, i + 2, false);

            // Option 2: skip
            int skip = helper(prices, i + 1, true);

            return Math.max(sell, skip);
        } else {
            // Option 1: buy today
            int buy = -prices[i] + helper(prices, i + 1, true);

            // Option 2: skip
            int skip = helper(prices, i + 1, false);

            return Math.max(buy, skip);
        }
    }
}