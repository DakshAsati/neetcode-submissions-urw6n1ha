class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate("", 2*n, ans);
        return ans;
    }

    private void generate(String curr, int len, List<String> ans){

        if(curr.length() == len){
            if(isValid(curr)){
                ans.add(curr);
            }
            return;
        }

        generate(curr + "(", len, ans);
        generate(curr + ")", len, ans);
    }

    private boolean isValid(String s){

        int balance = 0;

        for(char c : s.toCharArray()){

            if(c == '(') balance++;
            else balance--;

            if(balance < 0) return false;
        }

        return balance == 0;
    }
}