class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return countpath(0,0,m,n,dp);
        
    }

    public static int countpath(int sr, int sc, int m, int n, int[][] dp){
        if(sr >= m ||  sc >= n) return 0;
        if(sr == m - 1 && sc == n - 1) return 1;

        if(dp[sr][sc] != 0) return dp[sr][sc];


        dp[sr][sc] = countpath(sr + 1, sc, m, n, dp) + countpath(sr, sc + 1, m , n, dp);

    

    return dp[sr][sc];
    }
}
