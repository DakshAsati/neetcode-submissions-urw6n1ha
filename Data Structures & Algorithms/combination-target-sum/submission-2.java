class Solution {

    public void solve(int[] nums, int index, int sum, int target, List<Integer> ds, List<List<Integer>> result){

        if(sum == target){
            result.add(new ArrayList<>(ds));

        }

        if(sum > target) return;


        for(int i = index; i < nums.length; i++){
            ds.add(nums[i]);
            solve(nums, i, sum + nums[i], target, ds, result);
            ds.remove(ds.size() - 1);
        }

    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> ds = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        solve(nums,0,0,target, ds, result);
        return result;

        
    }
}
