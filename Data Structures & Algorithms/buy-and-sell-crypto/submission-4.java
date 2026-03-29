class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int left = 0;

        for(int i = 0; i < prices.length; i++){
            if(prices[i] < prices[left]){
                left = i;
            }else{
                int curr = prices[i] - prices[left];
                max = Math.max(curr,max);
            }
        }
        return max;

        
    }
}
