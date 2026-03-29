class Solution {
    public int search(int[] nums, int target) {
        // Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                return i;
            }
        }

        return -1;
    }
}
/*

sort the array and use for loop and find the target using 
iterating the "i" on whole array and find the match with target*/