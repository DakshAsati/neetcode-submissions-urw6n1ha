class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> maxheap = new PriorityQueue<>((a,b) -> distance(b) - distance(a));


        for(int[] point : points){
            maxheap.add(point);
            if(maxheap.size() > k){
                maxheap.poll();
            }
        }

        int[][] result = new int[k][2];
        int i = 0;
        while(!maxheap.isEmpty()){
            result[i++] = maxheap.poll();
        }

        return result;
        

    }

    private int distance(int[] point){
        return point[0] * point[0] + point[1] * point[1];
    }
}
