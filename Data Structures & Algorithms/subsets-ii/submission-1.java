class Solution {

    public void solve(int[] nums, int index, List<Integer> ds, List<List<Integer>> result){

        result.add(new ArrayList<>(ds));


        for(int i = index; i < nums.length; i++){
            if(i > index && nums[i] == nums[i - 1])continue;
            ds.add(nums[i]);
            solve(nums, i + 1 ,ds, result);
            ds.remove(ds.size() - 1);

        }

    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ds = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        solve(nums, 0, new ArrayList<>(), result);
        return result;
        
    }
}
