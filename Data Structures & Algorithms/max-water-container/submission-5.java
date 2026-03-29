class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        // int width = 0;
        int maxarea = 0;


        while(left < right){
            int width = right - left;
            int height = Math.min(heights[left], heights[right]);
            int area = width * height;

            maxarea = Math.max(area,maxarea);
        
if(heights[left] < heights[right]){
    left++;
}else{
    right--;
}

        
    }

    return maxarea;
}
}

/*
    calculate area that water covers
    calculate height
    calculate width
    calculate area

    */
