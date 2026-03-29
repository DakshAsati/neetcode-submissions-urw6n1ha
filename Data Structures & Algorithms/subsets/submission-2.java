class Solution {

       public void solve(int[] nums,int index, List<Integer> ds, List<List<Integer>> result){
         result.add(new ArrayList<>(ds));

        for(int i = index; i < nums.length; i++){
            ds.add(nums[i]);
            solve(nums, i + 1, ds, result);
            ds.remove(ds.size() - 1);
        }

    }
    public List<List<Integer>> subsets(int[] nums) {
          List<Integer> ds = new ArrayList<>();
            List<List<Integer>> result = new ArrayList<>();
            solve(nums, 0, new ArrayList<>(), result);
            return result;

     
        
    }
}
