class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int row = grid.length;
        int cols = grid[0].length;
        int maxarea = 0;

        for(int i = 0; i < row; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 1){
                    int area = dfs(i, j, grid);
                    maxarea = Math.max(area, maxarea);
                }
            }
        }
        
        return maxarea;
    }

    private int dfs(int i, int j, int[][] grid){

        if( i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return 0 ;

        if(grid[i][j] == 0) return 0 ;

        grid[i][j] = 0;

        int area = 1;
            area += dfs(i + 1, j , grid);
            area += dfs(i - 1, j , grid);
            area += dfs(i, j + 1, grid);
            area += dfs(i, j - 1, grid);

        return area;

    }
}
