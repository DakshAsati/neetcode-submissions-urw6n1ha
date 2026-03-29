class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> leftParen = new Stack<>();
        Stack<Integer> stars = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                leftParen.push(i);     // store index of '('
            } else if (ch == '*') {
                stars.push(i);         // store index of '*'
            } else if (ch == ')') {
                if (!leftParen.isEmpty()) {
                    leftParen.pop();   // match ')' with '('
                } else if (!stars.isEmpty()) {
                    stars.pop();       // match ')' with '*'
                } else {
                    return false;      // no match possible
                }
            }
        }

        // Match remaining '(' with '*' (as ')')
        while (!leftParen.isEmpty() && !stars.isEmpty()) {
            if (leftParen.peek() < stars.peek()) {
                leftParen.pop();
                stars.pop();
            } else {
                // '*' before '(' can't match
                return false;
            }
        }

        return leftParen.isEmpty();
    }
}
