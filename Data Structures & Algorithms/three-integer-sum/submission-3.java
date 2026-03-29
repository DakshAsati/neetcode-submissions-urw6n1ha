class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;

        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0; i < n - 2; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i  + 1;
            int right = nums.length - 1;

            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];

                if(sum == 0){
                    list.add(Arrays.asList(nums[i], nums[left],nums[right]));
                


                while(left < right && nums[left] == nums[left + 1])left++;
                while(left < right && nums[right] == nums[right - 1])right--;

                left++;
                right--;
            

            }else{
              if(sum < 0){
                left = left + 1;
            
            }else{
                right = right - 1;
            }
            }
            }
        }
        
        return list;
            }
        }
        

        
    /*

    check sum == 0 if yes return in list and not return empty list
    checkking duplicates everytime 
    make left and right with one for loop for iteration with "i"
    and with help of summation of three find it is equal to zero or not
    */
