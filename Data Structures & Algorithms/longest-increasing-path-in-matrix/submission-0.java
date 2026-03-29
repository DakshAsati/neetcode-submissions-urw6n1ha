class Solution {
    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) return 0;
        
        int m = matrix.length, n = matrix[0].length;
        int[][] memo = new int[m][n]; // memo[i][j] = longest path starting from (i,j)
        int maxPath = 0;
        
        // Try starting from every cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxPath = Math.max(maxPath, dfs(matrix, i, j, memo));
            }
        }
        
        return maxPath;
    }
    
    private int dfs(int[][] matrix, int i, int j, int[][] memo) {
        // If already computed, return cached result
        if (memo[i][j] != 0) return memo[i][j];
        
        int maxLength = 1; // Minimum path length is 1 (the cell itself)
        
        // Explore all 4 directions
        for (int[] dir : DIRECTIONS) {
            int x = i + dir[0];
            int y = j + dir[1];
            
            // Check bounds and strictly increasing condition
            if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && 
                matrix[x][y] > matrix[i][j]) {
                maxLength = Math.max(maxLength, 1 + dfs(matrix, x, y, memo));
            }
        }
        
        memo[i][j] = maxLength;
        return maxLength;
    }
}