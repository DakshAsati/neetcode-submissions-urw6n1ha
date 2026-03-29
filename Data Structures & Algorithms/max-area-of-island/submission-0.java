class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int count = 0;
        int maxarea = 0;
        int row = grid.length;
        int cols = grid[0].length;


        for(int i = 0; i < row; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 1){
                   int area = dfs(grid, i, j);
                   maxarea = Math.max(maxarea, area);
                    
                }
            }
        }

        return maxarea;



        
    }

    public int dfs(int[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)return 0;


        if(grid[i][j] == 0)return 0 ;

        grid[i][j] = 0;

        int area = 1;
        area += dfs(grid, i + 1, j);
        area += dfs(grid, i - 1, j);
        area += dfs(grid, i, j + 1);
        area += dfs(grid, i, j - 1);

        return area;
        
    }
}
