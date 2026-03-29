class Solution {
    public int findDuplicate(int[] nums) {

        int slow = nums[0];
        int fast = nums[0];

        // step 1: find meeting point
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);

        // step 2: find cycle start
        slow = nums[0];

        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}