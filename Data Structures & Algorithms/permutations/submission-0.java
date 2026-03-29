class Solution {
    public void helper(int[] nums, int index, List<List<Integer>> ans){
        int n = nums.length;
        if(index == n - 1){
            List<Integer> l = new ArrayList<>();
            for(int i = 0; i < n; i++){
                l.add(nums[i]);
            }
            ans.add(l);
            return;
        }

        for(int i = index; i < n; i++){
            swap(i, index, nums);
            helper(nums, index + 1, ans);
            swap(i, index, nums);
        }

    }
    public void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums, 0, ans);
        return ans;
        
    }
}
