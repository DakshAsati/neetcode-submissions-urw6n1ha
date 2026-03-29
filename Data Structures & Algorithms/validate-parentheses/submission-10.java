class Solution {
    public boolean isValid(String s) {

        Stack<Character> st = new Stack<>();


        for(char str : s.toCharArray()){
            if(str == '('){
                st.push(')');
            }else if(str == '{'){
                st.push('}');
            }else if(str == '['){
                st.push(']');
            }else if(st.isEmpty() || st.pop() != str){
                    return false;
                }

            }

            return st.isEmpty();
        }
        
    }

