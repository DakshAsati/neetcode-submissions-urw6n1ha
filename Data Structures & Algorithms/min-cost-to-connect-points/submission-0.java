class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        boolean[] visited = new boolean[n];

        int edgeused = 0;
        int totalcost = 0;

        minHeap.offer(new int[]{0,0});


        while(edgeused < n){
            int[] curr = minHeap.poll();
            int cost = curr[0];
            int i = curr[1];


            if(visited[i]) continue;
            visited[i] = true;
            totalcost += cost;
            edgeused++;


            for(int j = 0; j < n; j++){
                if(!visited[j]){
                    int dist = Math.abs(points[i][0] - points[j][0])
                                + Math.abs(points[i][1] - points[j][1]);
                            minHeap.offer(new int[]{dist,j});
                }
            }
        }
        return totalcost;
    }
}
