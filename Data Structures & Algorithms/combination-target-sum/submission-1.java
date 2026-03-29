class Solution {
       public void solve(int[] nums, int index, int sum, int target, List<Integer> ans, List<List<Integer>> result){
        if(sum == target){
            result.add(new ArrayList<>(ans));


        }
        if(sum > target) return;

        for(int i = index; i < nums.length; i++){
            ans.add(nums[i]);
            solve(nums, i, sum + nums[i], target, ans,result);
            ans.remove(ans.size() - 1);
        }
          
        }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
          List<List<Integer>> result = new ArrayList<>();
            solve(nums, 0,0,target, new ArrayList<>(),result);
            return result;

        

     
        
    }
}
