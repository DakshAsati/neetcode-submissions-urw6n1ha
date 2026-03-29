class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int count1 = 0, count2 = 0;
        Integer cand1 = null, cand2 = null;

        for(int n : nums){
            if(cand1 != null && n == cand1){
                count1++;
            }else if(cand2 != null && n == cand2){
                    count2++;
            }else if(count1 == 0){
                cand1= n;
                count1 = 1;
            }else if(count2 == 0){
                cand2 = n;
                count2 = 1;
            }else {
                count1--;
                count2--;
            }
        }

        count1 =  0;
        count2 = 0;
        for(int n : nums){
            if(n == cand1) count1++;
            
        else if(n == cand2) count2++;
        }


    

    List<Integer> result = new ArrayList<>();
    int len = nums.length;

    if(count1 > len / 3) result.add(cand1);
    if(count2 > len / 3) result.add(cand2);


return result;

    }
}