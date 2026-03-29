class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0) return result;

        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        // Pacific -> top row & left col
        for (int c = 0; c < cols; c++) {
            dfs(heights, 0, c, pacific);
        }
        for (int r = 0; r < rows; r++) {
            dfs(heights, r, 0, pacific);
        }

        // Atlantic -> bottom row & right col
        for (int c = 0; c < cols; c++) {
            dfs(heights, rows - 1, c, atlantic);
        }
        for (int r = 0; r < rows; r++) {
            dfs(heights, r, cols - 1, atlantic);
        }

        // Intersection
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }
        return result;
    }

    private void dfs(int[][] heights, int r, int c, boolean[][] visited) {
        int rows = heights.length, cols = heights[0].length;
        if (visited[r][c]) return;

        visited[r][c] = true;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        for (int[] d : dirs) {
            int nr = r + d[0];
            int nc = c + d[1];

            if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;

            // reverse flow condition
            if (heights[nr][nc] >= heights[r][c]) {
                dfs(heights, nr, nc, visited);
            }
        }
    }
}
