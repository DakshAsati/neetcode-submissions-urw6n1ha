class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        
        // Edge cases
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        // Case 1: Rob from 0 to n - 2 (exclude last)
        int case1 = robLinear(nums, 0, n - 2);
        
        // Case 2: Rob from 1 to n - 1 (exclude first)
        int case2 = robLinear(nums, 1, n - 1);

        return Math.max(case1, case2);
    }

    private int robLinear(int[] nums, int start, int end) {
        int rob1 = 0, rob2 = 0;

        for (int i = start; i <= end; i++) {
            int newRob = Math.max(rob1 + nums[i], rob2);
            rob1 = rob2;
            rob2 = newRob;
        }

        return rob2;
    }
}
