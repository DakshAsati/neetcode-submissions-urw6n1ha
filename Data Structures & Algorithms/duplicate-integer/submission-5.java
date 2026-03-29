class Solution {
    public boolean hasDuplicate(int[] nums) {
        if(nums == null || nums.length == 0)return false;

        Set<Integer> set = new HashSet<>();
        for(int seen : nums){
            if(set.contains(seen)){
                return true;
            }

            set.add(seen);

        }
        return false;
        
    }
}