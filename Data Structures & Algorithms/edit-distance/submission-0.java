class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        // dp[i][j] = min operations to convert word1[0..i-1] -> word2[0..j-1]
        int[][] dp = new int[n + 1][m + 1];

        // If word1 is empty, we need j insertions
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }

        // If word2 is empty, we need i deletions
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }

        // Fill DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; // no change needed
                } else {
                    int insert = dp[i][j - 1];     // insert word2[j-1]
                    int delete = dp[i - 1][j];     // delete word1[i-1]
                    int replace = dp[i - 1][j - 1]; // replace word1[i-1] with word2[j-1]
                    dp[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
                }
            }
        }

        return dp[n][m];
    }
}
