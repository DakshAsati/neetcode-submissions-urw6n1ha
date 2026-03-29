class Solution {
    public int maxProfit(int[] prices) {
        int left = 0;
        int max = 0;

        for(int i = 0; i < prices.length; i++){
            if(prices[i] < prices[left]){
                left = i;
            }else{

                int currentprice = prices[i] - prices[left];
                max = Math.max(currentprice, max);
            }

        }
            return max;
        
    }
}
