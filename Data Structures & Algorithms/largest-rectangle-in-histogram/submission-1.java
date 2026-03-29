class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxarea = 0;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = - 1;
        right[n - 1] = n;


        for(int i = 1; i < n; i++){
            int prev = i - 1;
            while(prev >= 0 && heights[prev] >= heights[i]){
                prev = left[prev];
            }

            left[i] = prev;
        }
        
        for(int i = n - 2; i >= 0; i--){
            int prev = i + 1;
            while(prev < n && heights[prev] >= heights[i]){
                prev = right[prev];
            }

            right[i] = prev;
        }
        for(int i = 0; i < n; i++){
            int width = right[i] - left[i] - 1;
            maxarea = Math.max(maxarea, heights[i] * width);
        }
        return maxarea;
    }
}
