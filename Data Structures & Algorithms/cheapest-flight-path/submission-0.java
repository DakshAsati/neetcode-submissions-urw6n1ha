
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        // Build adjacency list
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] f : flights) {
            graph[f[0]].add(new int[]{f[1], f[2]}); // {to, price}
        }

        // Queue: {city, cost so far, stops used}
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{src, 0, 0});
        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[src] = 0;

        int ans = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int city = cur[0], cost = cur[1], stops = cur[2];

            if (city == dst) {
                ans = Math.min(ans, cost);
            }
            if (stops > K) continue;

            for (int[] next : graph[city]) {
                int nextCity = next[0], price = next[1];
                int newCost = cost + price;
                // Only continue if newCost < minCost[nextCity] to prune
                if (newCost < minCost[nextCity]) {
                    minCost[nextCity] = newCost;
                    q.offer(new int[]{nextCity, newCost, stops + 1});
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
