class Solution {

    public void solve(int[] nums, int index, List<Integer> list, List<List<Integer>> result){

       
            result.add(new ArrayList<>(list));
        

        for(int i = index; i < nums.length; i++){
            list.add(nums[i]);
            solve(nums, i + 1, list, result);
            list.remove(list.size() - 1);
        }

    }
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        solve(nums, 0, new ArrayList<>(), result);
        return result;

        
    }
}
