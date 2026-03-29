/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        // if(intervals.size() == 0 || intervals == null) return false;
        intervals.sort(Comparator.comparingInt(i -> i.start));
            int n = intervals.size();


            for(int i = 1; i <= n - 1; i++){
                if(intervals.get(i - 1).end > intervals.get(i).start){
                    return false;
                }

            }

            return true;


    }
}
