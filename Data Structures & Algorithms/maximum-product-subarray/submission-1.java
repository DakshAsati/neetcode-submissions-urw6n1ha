class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int currMax = nums[0];
        int currMin = nums[0]; // track min also (because negative * negative = positive)

        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];

            // swap before updating (important when n is negative)
            if (n < 0) {
                int temp = currMax;
                currMax = currMin;
                currMin = temp;
            }

            currMax = Math.max(n, currMax * n);
            currMin = Math.min(n, currMin * n);

            res = Math.max(res, currMax);
        }
        return res;
    }
}
