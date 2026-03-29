class Solution {
    public void solve(char[][] board) {
        if(board == null || board.length == 0)return;

        int rows = board.length;
        int cols = board[0].length;

        char[][] slate = new char[rows][cols];  

        for(int r = 0; r < rows; r++){
            Arrays.fill(slate[r], 'X');
        }

        boolean[][] visited = new boolean[rows][cols];

        for(int c = 0; c < cols; c++){
            if(board[0][c] == 'O')dfs(board, slate, 0, c, visited);
            if(board[rows - 1][c] == 'O')dfs(board, slate, rows - 1, c, visited);
        }
        for(int r = 0; r < rows; r++){
            if(board[r][0] == 'O')dfs(board, slate, r, 0, visited);
            if(board[r][cols - 1] == 'O')dfs(board, slate, r, cols - 1, visited);
        }

        for(int r = 0; r < rows; r++){
            for(int c = 0;c < cols; c++){
                board[r][c] = slate[r][c];
            }
        }
        
    }

    public void dfs(char[][] board, char[][] slate, int r, int c, boolean[][] visited){
        int rows = board.length, cols = board[0].length;

        if(r < 0  || r >= rows || c < 0 || c >= cols)return;
        if(board[r][c] != 'O' || visited[r][c]) return;


        visited[r][c] = true;
        slate[r][c] = 'O';

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        for(int[] d : dirs){
            dfs(board,slate, r + d[0], c + d[1], visited);
        }
    }
}
