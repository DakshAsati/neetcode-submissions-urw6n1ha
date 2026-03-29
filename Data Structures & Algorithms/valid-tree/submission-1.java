class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n - 1)return false;

        List<List<Integer>> adj  = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());

        } 

        for(int[] e : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        boolean[] vis = new boolean[n];

        iterate(0, adj, vis);

        for(boolean v : vis){
            if(!v) return false;
        }
        return true;



    }

    public void iterate(int curr, List<List<Integer>> adj, boolean[] vis){
        vis[curr] = true;


        for(int nei : adj.get(curr)){
            if(!vis[nei]){
                iterate(nei, adj, vis);
            }
        }
    }
}
