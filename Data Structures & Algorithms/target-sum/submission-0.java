class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) sum += num;
        
        // If (target + sum) is odd or target is out of range, no solution
        if ((target + sum) % 2 != 0 || Math.abs(target) > sum) return 0;
        
        int subsetSum = (target + sum) / 2;
        return countSubsets(nums, subsetSum);
    }
    
    private int countSubsets(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1; // one way to make sum 0
        
        for (int num : nums) {
            // Traverse backwards to avoid overwriting results
            for (int j = target; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        
        return dp[target];
    }
}
