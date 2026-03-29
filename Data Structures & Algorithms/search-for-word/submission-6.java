class Solution {

    public boolean exist(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(search(board, word, i, j, "", visited)){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean search(char[][] board, String word, int row, int col, String path, boolean[][] visited){

        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || visited[row][col]){
            return false;
        }

        path += board[row][col];
        visited[row][col] = true;

        if(path.equals(word)) return true;

        boolean found = search(board, word, row+1, col, path, visited) ||
                        search(board, word, row-1, col, path, visited) ||
                        search(board, word, row, col+1, path, visited) ||
                        search(board, word, row, col-1, path, visited);

        visited[row][col] = false;

        return found;
    }
}