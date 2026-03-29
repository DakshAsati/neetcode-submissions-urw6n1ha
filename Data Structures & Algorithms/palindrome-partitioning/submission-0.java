class Solution {
    public void helper(String s, int index, List<String> ds, List<List<String>> result) {
        if (index == s.length()) {
            result.add(new ArrayList<>(ds));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if(isPalindrome(s,index, i)){
            ds.add(s.substring(index, i +1)); 
            helper(s, i + 1, ds, result);
            ds.remove(ds.size() - 1); 
        }
    }
    }

    private boolean isPalindrome(String s, int start, int end){
        while(start < end){
            if(s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        helper(s, 0, new ArrayList<>(), result);
        return result;
    }
}
