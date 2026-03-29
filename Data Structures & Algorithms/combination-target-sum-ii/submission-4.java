class Solution {

    public void helper(int[] candidates, int index,  int target, List<Integer> ds, List<List<Integer>> result){

        if(target == 0){
            result.add(new ArrayList<>(ds));
        }

        for(int i = index; i < candidates.length; i++){
            if(i > index && candidates[i] == candidates[i - 1]) continue;

                ds.add(candidates[i]);
                helper(candidates, i + 1, target - candidates[i],  ds, result);
                ds.remove(ds.size() - 1);

            
        }

    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> ds = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        helper(candidates, 0 ,target, new ArrayList<>(), result);
        return result;


        
    }
}
