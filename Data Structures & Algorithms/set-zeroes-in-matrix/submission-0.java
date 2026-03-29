class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;

        int rows = matrix.length;
        int cols = matrix[0].length;


        boolean[] rowszero = new boolean[rows];
        boolean[] colszero = new boolean[cols];


        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(matrix[i][j] == 0){
                    rowszero[i] = true;
                    colszero[j] = true;
                }
            }
        }

        for(int i = 0; i < rows; i++){
            if(rowszero[i]){
                for(int j = 0; j < cols; j++){
                    matrix[i][j] = 0;
                }
            }
        }

        for(int j = 0; j < cols; j++){
            if(colszero[j]){
                for(int i = 0; i < rows; i++){
                    matrix[i][j] = 0;
                }
            }
        }
        
    }
}
