class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0)return new int[0][];

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));

        List<int[]> result = new ArrayList<>();
        int[] currentlevel = intervals[0];

        for(int i = 1; i < intervals.length; i++){
            if(currentlevel[1] >= intervals[i][0]){
                currentlevel[1] = Math.max(currentlevel[1], intervals[i][1]);
            }else{
                result.add(currentlevel);
                currentlevel = intervals[i];
            }
        }
        result.add(currentlevel);
        return result.toArray(new int[result.size()][]);
        
    }
}
