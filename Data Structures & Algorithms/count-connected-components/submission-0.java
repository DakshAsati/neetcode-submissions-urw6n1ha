class Solution {
    public int countComponents(int n, int[][] edges) {

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] e : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        boolean[] vis = new boolean[n];
        int count = 0;

        for(int i = 0; i < n; i++){
            if(!vis[i]){
                dfs(i, vis,adj);
                count++;
            }
        }

        return count;

       

      


    }

    public void dfs(int node, boolean[] vis,  List<List<Integer>> adj){
        vis[node] = true;

        for(int nei : adj.get(node)){
            if(!vis[nei]){
                dfs(nei, vis,adj);  
            }
        }

       
}
}
