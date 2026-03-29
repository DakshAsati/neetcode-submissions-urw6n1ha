class Solution {
    public int maxProfit(int[] prices) {
        int maxsofar = 0;
        int curr = 0;

        for(int i = 1; i < prices.length; i++){
             curr += prices[i] - prices[i - 1];
           curr = Math.max(curr,0);
            maxsofar = Math.max(maxsofar, curr);

        }        

        return maxsofar;
    }
}
