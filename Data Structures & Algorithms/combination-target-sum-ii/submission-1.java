class Solution {

    public void helper(int[] candidates, int index, int target, List<Integer> ds, List<List<Integer>> ans){
        if(target  == 0){
            ans.add(new ArrayList<>(ds));
            return;
        }
          


   for (int i = index; i < candidates.length; i++) {
    if (i > index && candidates[i] == candidates[i - 1]) continue;  

    ds.add(candidates[i]);
    helper(candidates, i + 1, target - candidates[i], ds, ans);
    ds.remove(ds.size() - 1);
}


    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> ds = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        helper(candidates, 0, target, new ArrayList<>(), ans);
        return ans;
        
    }
}
