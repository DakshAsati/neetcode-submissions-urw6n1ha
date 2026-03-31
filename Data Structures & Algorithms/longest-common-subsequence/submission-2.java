class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        return helper(text1, text2, text1.length(), text2.length());
    }

    public int helper(String t1, String t2, int i, int j) {
        if (i == 0 || j == 0) return 0;

        if (t1.charAt(i - 1) == t2.charAt(j - 1)) {
            return 1 + helper(t1, t2, i - 1, j - 1);
        } else {
            return Math.max(
                helper(t1, t2, i - 1, j),
                helper(t1, t2, i, j - 1)
            );
        }
    }
}