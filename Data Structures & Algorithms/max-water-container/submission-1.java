class Solution {
    public int maxArea(int[] heights) {

        int left = 0;
        int right = heights.length - 1;
        int maxarea = 0;


        while(left < right){
            int width = right - left;
            int length = Math.min(heights[right], heights[left]);
            int area = width * length;
            maxarea = Math.max(area, maxarea);

            if(heights[left] < heights[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxarea;
        
    }
}
