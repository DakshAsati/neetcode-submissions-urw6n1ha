class Solution {
    public int jump(int[] nums) {
        int maxreach = 0;
        int farthest = 0;
        int len = 0;

        for(int i = 0; i < nums.length - 1; i++){
            farthest = Math.max(farthest, i + nums[i]);

            if(i == maxreach){
                len++;
                maxreach = farthest;
            }

        }
        return len;
        
    }
}
