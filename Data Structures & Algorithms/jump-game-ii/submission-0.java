class Solution {
    public int jump(int[] nums) {
        int maxreach = 0;
        int len = 0;
        int farthest = 0;
        
        for(int i = 0; i < nums.length - 1 ; i++){

            maxreach = Math.max(maxreach, i + nums[i]);

            if(i == farthest){
                len++;
                farthest = maxreach;
            }
        }
        return len;
        
        
    }
}
