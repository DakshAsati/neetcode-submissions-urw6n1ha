class Solution {
    public int uniquePaths(int m, int n) {
        return countpath(0,0,m,n);
        
    }

    public static int countpath(int sr, int sc, int m, int n){
        if(sr >= m ||  sc >= n) return 0;
        if(sr == m - 1 && sc == n - 1) return 1;


    return countpath(sr + 1, sc, m, n) + countpath(sr, sc + 1, m , n);
    }
}
