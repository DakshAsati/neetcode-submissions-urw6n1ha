class Solution {
  public int jump(int[] nums) {
    return helper(nums, 0);
}

private int helper(int[] nums, int index) {
    int n = nums.length;

    // Reached or crossed last index
    if (index >= n - 1) return 0;

    // Can't move forward
    if (nums[index] == 0) return Integer.MAX_VALUE;

    int min = Integer.MAX_VALUE;

    for (int step = 1; step <= nums[index]; step++) {
        int next = helper(nums, index + step);
        if (next != Integer.MAX_VALUE) {
            min = Math.min(min, 1 + next);
        }
    }

    return min;
}
}