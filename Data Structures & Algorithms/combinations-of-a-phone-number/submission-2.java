class Solution {

    public void helper(String digits, String[] mapping, int index, StringBuilder sb,  List<String> result){
        if(index == digits.length()) {
            result.add(sb.toString());
            return;
        }

        String str = mapping[digits.charAt(index) - '0'];

        for(int i = 0; i < str.length(); i++){
            sb.append(str.charAt(i));
            helper(digits, mapping, index + 1, sb,result);
            sb.deleteCharAt(sb.length()  - 1);
        }



    }
    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        if(digits == null || digits.length() == 0) return result;

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

        helper(digits, mapping, 0, new StringBuilder(), result);

        return result;
        
    }
}
