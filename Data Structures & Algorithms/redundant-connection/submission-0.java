
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        List<List<Integer>> adj = new ArrayList<>();

        // adjacency list size n+1 (1-based nodes)
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        // try adding edges one by one, check cycle
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            boolean[] vis = new boolean[n + 1];

            // DFS se check karo ki u se v already connected hai ya nahi
            if (dfs(u, v, -1, adj, vis)) {
                return edge; // agar connected tha -> ye edge cycle banayega
            }

            // otherwise safe hai -> add to graph
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return new int[0]; // ideally kabhi nahi aayega
    }

    private boolean dfs(int src, int target, int parent,
                        List<List<Integer>> adj, boolean[] vis) {
        if (src == target) return true;

        vis[src] = true;
        for (int nei : adj.get(src)) {
            if (nei == parent) continue; // back edge ko ignore karo
            if (!vis[nei]) {
                if (dfs(nei, target, src, adj, vis)) return true;
            }
        }
        return false;
    }
}
