class Solution {

    public void solve(int[] nums, int index, List<Integer> ds, List<List<Integer>> result){

        if(index == nums.length){
            result.add(new ArrayList<>(ds));
            return;
        }

        // take element
        ds.add(nums[index]);
        solve(nums, index + 1, ds, result);

        ds.remove(ds.size() - 1);

        // skip element
        solve(nums, index + 1, ds, result);
    }

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();

        solve(nums, 0, ds, result);

        return result;
    }
}