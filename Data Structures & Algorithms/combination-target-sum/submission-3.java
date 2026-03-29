class Solution {

    public void solve(int[] nums, int index, int sum, int target,
                      List<Integer> ds, List<List<Integer>> result){

        if(index == nums.length){
            if(sum == target){
                result.add(new ArrayList<>(ds));
            }
            return;
        }

        // TAKE current element
        if(sum + nums[index] <= target){
            ds.add(nums[index]);
            solve(nums, index, sum + nums[index], target, ds, result);
            ds.remove(ds.size() - 1);
        }

        // SKIP current element
        solve(nums, index + 1, sum, target, ds, result);
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();

        solve(nums, 0, 0, target, ds, result);

        return result;
    }
}