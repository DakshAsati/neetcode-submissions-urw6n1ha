class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;

        int n = prices.length;
        int hold = -prices[0];
        int sold = 0;
        int rest = 0;

        for(int i = 1; i < n; i++){
            int prev_sold = sold;


            sold = hold + prices[i];

            hold = Math.max(hold, rest - prices[i]);

            rest = Math.max(rest, prev_sold);
        }
        return Math.max(sold,rest);
    }
}