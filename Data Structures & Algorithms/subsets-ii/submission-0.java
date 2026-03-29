class Solution {
    public void helper(int[] nums, int index, List<Integer> ds, List<List<Integer>> ans){

        ans.add(new ArrayList<>(ds));

        for(int i = index; i < nums.length; i++){
            if(i > index && nums[i] == nums[i - 1])continue;
            ds.add(nums[i]);
            helper(nums, i + 1, ds, ans);
            ds.remove(ds.size() - 1);


        }

    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums, 0, new ArrayList<>(), ans);
        return ans;
        
    }
}
