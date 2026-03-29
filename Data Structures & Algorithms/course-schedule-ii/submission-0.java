class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());

        }
        for(int[] pre :prerequisites){
            adj.get(pre[1]).add(pre[0]);
        }

        boolean[] vis = new boolean[numCourses];
        boolean[] rec = new boolean[numCourses];
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < numCourses; i++){
            if(!vis[i]){
                if(cycledetected(i, vis,rec, adj,st)){
                    return new int[0];
                }
            }
        }

       int[] ans = new int[numCourses];
       int idx = 0;
       while(!st.isEmpty()){
        ans[idx++] = st.pop();
       }

       return ans;
    }

    public boolean cycledetected(int curr, boolean vis[], boolean rec[],List<List<Integer>> adj,Stack<Integer> st){
        vis[curr] = true;
        rec[curr] = true;

        for(int neighbour : adj.get(curr)){
            if(rec[neighbour]){
                return true;
            }else if(!vis[neighbour]){
                if (cycledetected(neighbour, vis, rec, adj,st)) return true;

            }
        }
    
    rec[curr] = false;
    st.push(curr);
    return false;
}
}