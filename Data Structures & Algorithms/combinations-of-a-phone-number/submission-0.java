class Solution {

    public void helper(String digits, int index, String[] mapping, StringBuilder ds, List<String> ans){
        if(index == digits.length()){
            ans.add(ds.toString());
            return;
        }

        String str = mapping[digits.charAt(index) - '0'];

        for(int i = 0; i < str.length(); i++){
            ds.append(str.charAt(i));
            helper(digits, index + 1,mapping, ds, ans);
            ds.deleteCharAt(ds.length() - 1);
        }

    }
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();

        if(digits == null || digits.length() == 0)return ans;

            String[] mapping = {
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
        };    
        helper(digits, 0, mapping,  new StringBuilder(), ans);
        return ans;    
    }
}
