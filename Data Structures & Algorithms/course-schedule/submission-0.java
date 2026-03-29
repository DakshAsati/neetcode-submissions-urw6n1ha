class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses <=  0)return false;
        if(prerequisites == null || prerequisites.length == 0) return true;

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());

        }
        for(int[] pre :prerequisites){
            adj.get(pre[1]).add(pre[0]);
        }

        boolean[] vis = new boolean[numCourses];
        boolean[] rec = new boolean[numCourses];

        for(int i = 0; i < numCourses; i++){
            if(!vis[i]){
                if(cycledetected(i, vis,rec, adj)){
                    return false;
                }
            }
        }

        return true;
    }

    public boolean cycledetected(int curr, boolean vis[], boolean rec[],List<List<Integer>> adj){
        vis[curr] = true;
        rec[curr] = true;

        for(int neighbour : adj.get(curr)){
            if(rec[neighbour]){
                return true;
            }else if(!vis[neighbour]){
                if (cycledetected(neighbour, vis, rec, adj)) return true;

            }
        }
    
    rec[curr] = false;
    return false;
}
}