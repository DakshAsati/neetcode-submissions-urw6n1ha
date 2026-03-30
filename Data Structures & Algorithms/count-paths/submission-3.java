class Solution {
    public int uniquePaths(int m, int n) {
        return countPaths(0, 0, m, n);
    }

    private int countPaths(int sr, int sc, int m, int n){
        if(sr >= m || sc >= n) return 0;
        if(sr == m - 1 && sc == n - 1) return 1;

        return countPaths(sr + 1, sc, m, n) 
             + countPaths(sr, sc + 1, m, n);
    }
}