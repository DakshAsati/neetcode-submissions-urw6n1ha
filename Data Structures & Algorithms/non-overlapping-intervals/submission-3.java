class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals == null || intervals.length == 0)return 0;
       
        int n = intervals.length;

        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
         int[] current = intervals[0];

        int count = 0;

        for(int i = 1; i < n; i++){
            if(current[1] > intervals[i][0]){
                count++;
            
            if(current[1] > intervals[i][1]){
                current = intervals[i];
            }
        }else{
            current = intervals[i];
        }
        


        }

        return count;
    }
}
