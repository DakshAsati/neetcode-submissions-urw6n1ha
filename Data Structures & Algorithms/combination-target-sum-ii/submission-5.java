class Solution {

    public void helper(int[] arr, int index, List<Integer> ds, 
                       List<List<Integer>> res, int target){

        if(index == arr.length){

            int sum = 0;
            for(int num : ds) sum += num;

            if(sum == target){
                List<Integer> temp = new ArrayList<>(ds);
                Collections.sort(temp);
                if(!res.contains(temp)) res.add(temp);
            }

            return;
        }

        // pick
        ds.add(arr[index]);
        helper(arr, index + 1, ds, res, target);

        // not pick
        ds.remove(ds.size() - 1);
        helper(arr, index + 1, ds, res, target);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        helper(candidates, 0, new ArrayList<>(), res, target);
        return res;
    }
}
