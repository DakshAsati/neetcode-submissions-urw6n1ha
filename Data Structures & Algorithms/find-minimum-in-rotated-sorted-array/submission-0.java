class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = (low + high) / 2;

            if (nums[mid] > nums[high]) {
                // Minimum is in the right half
                low = mid + 1;
            } else {
                // Minimum is in the left half (including mid)
                high = mid;
            }
        }

        // At the end, low == high pointing to the minimum
        return nums[low];
    }
}
