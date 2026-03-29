
class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        
        // Min-heap: stores [elevation, row, col]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{grid[0][0], 0, 0});
        
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        
        int res = 0;
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int h = curr[0], r = curr[1], c = curr[2];
            
            res = Math.max(res, h);  // water level must be at least this high
            
            if (r == n - 1 && c == n - 1) {
                return res; // reached destination
            }
            
            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    pq.offer(new int[]{grid[nr][nc], nr, nc});
                }
            }
        }
        
        return -1; // unreachable (shouldn’t happen in valid input)
    }
}
