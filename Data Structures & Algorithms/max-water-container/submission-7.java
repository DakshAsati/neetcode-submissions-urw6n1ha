class Solution {
    public int maxArea(int[] heights) {
        int maxarea = 0;
        int left = 0;
        int right = heights.length - 1;

        while(left < right){

            int width = right - left;
            int height = Math.min(heights[right] , heights[left]);
            int area = width * height;

            maxarea = Math.max(maxarea, area);

        
      if(heights[left] < heights[right]){
        left++;
      }else{
        right--;
      }
        }

        return maxarea;
        
    }

}
