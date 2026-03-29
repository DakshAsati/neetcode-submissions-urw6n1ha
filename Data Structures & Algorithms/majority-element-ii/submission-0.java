class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int count1 = 0, count2 = 0;
        Integer cand1 = null, cand2 = null;

        // 1st pass: find candidates
        for (int n : nums) {
            if (cand1 != null && n == cand1) {
                count1++;
            } else if (cand2 != null && n == cand2) {
                count2++;
            } else if (count1 == 0) {
                cand1 = n;
                count1 = 1;
            } else if (count2 == 0) {
                cand2 = n;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // 2nd pass: verify counts
        count1 = 0;
        count2 = 0;
        for (int n : nums) {
            if (n == cand1) count1++;
            else if (n == cand2) count2++;
        }

        List<Integer> result = new ArrayList<>();
        int n = nums.length;

        if (count1 > n / 3) result.add(cand1);
        if (count2 > n / 3) result.add(cand2);

        return result;
    }
}
