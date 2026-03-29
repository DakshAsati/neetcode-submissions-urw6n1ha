class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : times){
            int u = edge[0], v = edge[1], w = edge[2];
            adj.get(u).add(new int[]{v,w});
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;


        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        pq.offer(new int[]{0,k});


        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int time = curr[0],node = curr[1];


            if(time > dist[node])continue;

            for(int[] nei : adj.get(node)){
                int v = nei[0], w = nei[1];

                if(dist[node] + w  < dist[v]){
                    dist[v] = dist[node] + w;
                    pq.offer(new int[]{dist[v], v});

                }
            }

        }

        int ans = 0;
        for(int i = 1; i <= n; i++){
            if(dist[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, dist[i]);
        }

return ans;
        
    }
}
