class Solution {

    public void helper(int[] nums, int index, int sum, int target, List<Integer> ds, List<List<Integer>> ans){
        if(sum == target){
            ans.add(new ArrayList<>(ds));
        }

        if(sum > target)return;

        for(int i = index; i < nums.length; i++){
            ds.add(nums[i]);
            helper(nums, i, sum + nums[i], target, ds, ans);
            ds.remove(ds.size() - 1);
        }

    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums, 0, 0, target, new ArrayList<>(),ans);
        return ans;
        
    }
}
