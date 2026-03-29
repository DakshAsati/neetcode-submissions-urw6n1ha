class Solution {
    public boolean isValidSudoku(char[][] board) {

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(!isValid(i,j,board)){
                    return false;
                }
            }
        }
        

        return true;
    }

    private boolean isValid(int row, int cols, char[][] board){
        if(board[row][cols] == '.') return true;


        for(int i = 0; i < 9; i++){
            if(cols != i && board[row][i] == board[row][cols]) return false;


            if(row != i && board[i][cols] == board[row][cols])  return false;


            if((3 * (row / 3) + i / 3) != row && (3 * ( cols / 3) + i  % 3) != cols
            && board[3 * (row / 3) + i / 3][ 3 * (cols / 3) + i  % 3] == board[row][cols]) return false;
        }

        return true;
    }
}
