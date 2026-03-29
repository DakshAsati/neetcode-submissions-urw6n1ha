class Solution {
    public int maxArea(int[] heights) {

        int n = heights.length;

        int left = 0;
        int right = heights.length - 1;
        int maxarea = 0;

        while(left < right){

            for(int i = 0; i < n; i++){
                int width = right - left;
                int height = Math.min(heights[left], heights[right]);
                int area = width * height;

            
            maxarea = Math.max(area, maxarea);
            }

        if(heights[left] < heights[right]){
            left++;
        }else{
            right--;
        }

       
        }
         return maxarea;
        
    }
}
