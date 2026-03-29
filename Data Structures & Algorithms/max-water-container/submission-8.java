class Solution {
    public int maxArea(int[] heights) {

      int maxarea = 0;
      int left = 0;
      int right = heights.length - 1;


      while(left < right){

        int width = right - left;
        int height = Math.min(heights[left], heights[right]);
        int area = width * height;

        maxarea = Math.max(area, maxarea);
      

      if(heights[left] < heights[right]){
        left = left + 1;
      }else{
        right = right - 1;

      }
      }
      return maxarea;
      
      
    }
}
