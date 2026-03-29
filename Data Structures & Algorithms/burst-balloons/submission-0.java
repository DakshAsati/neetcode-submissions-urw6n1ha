class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        
        // Add virtual balloons of value 1 at both ends
        int[] balloons = new int[n + 2];
        balloons[0] = 1;
        balloons[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            balloons[i + 1] = nums[i];
        }
        
        // dp[i][j] = max coins from bursting balloons from i to j
        int[][] dp = new int[n + 2][n + 2];
        
        // Iterate over different lengths of subarrays
        for (int len = 1; len <= n; len++) {
            for (int left = 1; left <= n - len + 1; left++) {
                int right = left + len - 1;
                
                // Try every balloon in range [left, right] as the last one to burst
                for (int last = left; last <= right; last++) {
                    int coins = balloons[left - 1] * balloons[last] * balloons[right + 1]
                              + dp[left][last - 1] 
                              + dp[last + 1][right];
                    
                    dp[left][right] = Math.max(dp[left][right], coins);
                }
            }
        }
        
        return dp[1][n];
    }
}