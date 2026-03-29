class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int i = 0, n = intervals.length;

        while(i < n && intervals[i][1] < newInterval[0]){
            res.add(intervals[i++]);
        }

        while(i < n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }

        res.add(newInterval);

        while(i < n){
            res.add(intervals[i++]);
        }

        return res.toArray(new int[res.size()][]);
        
    }
}

/* for inserting compare new[0] and new[1] with intervals[0][0] 
intervals[0][1] and intervals[1][0] intervals[1][1]

for overlapping checking
 intervals[0][1] > new[0]-> overlapped
 and more when loop runs

 */

