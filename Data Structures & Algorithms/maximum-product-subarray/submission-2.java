class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int currmax = nums[0];
        int currmin = nums[0];


        for(int i = 1; i < nums.length; i++){
            int n = nums[i];

            if(n < 0){
                int temp = currmax;
                currmax = currmin;
                currmin = temp;
            }

            currmax = Math.max(n, currmax * n);
            currmin = Math.min(n, currmin * n);


            res = Math.max(res, currmax);
        }

        return res;
        
    }
}
