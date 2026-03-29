class Solution {
    public int[][] kClosest(int[][] points, int k) {

        Arrays.sort(points, (a,b) -> distance(a) - distance(b));

        int[][] result = new int[k][2];
        for(int i = 0; i < k; i++){
            result[i] = points[i];
        }

        return result;
        

    }

    private int distance(int[] point){
        return point[0] * point[0] + point[1] * point[1];
    }
}
