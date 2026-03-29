

class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;

        int row = grid.length;
        int cols = grid[0].length;
        int[][] time = new int[row][cols];

        // initialize with infinity
        for(int i = 0; i < row; i++){
            Arrays.fill(time[i], Integer.MAX_VALUE);
        }

        // start DFS from all rotten oranges
        for(int i = 0; i < row; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 2){
                    dfs(grid, time, i, j , 0);
                }
            }
        }

        int ans = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 1){
                    if(time[i][j] == Integer.MAX_VALUE) {
                        return -1; // unreachable
                    }
                    ans = Math.max(ans, time[i][j]);
                }
            }
        }

        return ans;
    }

    public void dfs(int[][] grid, int[][] time, int i, int j,int currentTime){
        // boundary and better path check
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || currentTime >= time[i][j]){
            return;
        }

        time[i][j] = currentTime;

        dfs(grid, time, i + 1, j, currentTime + 1);
        dfs(grid, time, i - 1, j, currentTime + 1);
        dfs(grid, time, i, j + 1, currentTime + 1);
        dfs(grid, time, i, j - 1, currentTime + 1);
    }
}
