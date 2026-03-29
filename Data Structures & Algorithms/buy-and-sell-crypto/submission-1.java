class Solution {
    public int maxProfit(int[] prices) {

        int maxprofit = 0;
        int left = 0;

        for(int i = 0; i < prices.length; i++){
            if(prices[i] < prices[left]){
                left =  i ;
            }else{
                int currprofit = prices[i] - prices[left];
                maxprofit = Math.max(currprofit,maxprofit);
            }
        }
        return maxprofit;
        
    }
}
