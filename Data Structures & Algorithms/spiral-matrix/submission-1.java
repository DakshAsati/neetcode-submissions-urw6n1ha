class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int rowbegin = 0;
        int rowend = matrix.length - 1;
        int colbegin = 0;
        int colend = matrix[0].length - 1;

        while(rowbegin <= rowend && colbegin <= colend){


            for(int j = colbegin; j <= colend; j++){
                result.add(matrix[rowbegin][j]);
            }
            rowbegin++;

            for(int i = rowbegin; i <= rowend; i++){
                result.add(matrix[i][colend]);
            }
            colend--;

            if(rowbegin <= rowend){
                for(int i = colend; i >= colbegin; i--){
                    result.add(matrix[rowend][i]);
                }
                rowend--;
            }
            if(colbegin <= colend){
                for(int j = rowend; j >= rowbegin; j--){
                    result.add(matrix[j][colbegin]);
                }
                colbegin++;
            }

        }
        return result;
        
    }
}
