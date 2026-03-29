class Solution {
    public void helper(int[] nums, int index, List<List<Integer>> result){
        int n = nums.length;
        if(index == n - 1){
        List<Integer> l = new ArrayList<>();
        for(int i = 0; i < n; i++){
            l.add(nums[i]);

        }

        result.add(l);
        return ;

    }
        for(int i = index; i < n; i++){
            swap(i, index, nums);
            helper(nums, index + 1, result);
            swap(i, index, nums);

        }
    }

        public void swap(int i, int j, int[] nums){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, 0, result);
        return result;
    }
}
