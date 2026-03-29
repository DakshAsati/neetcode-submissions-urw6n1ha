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
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) return 0;

        // Sort intervals by start time
        intervals.sort(Comparator.comparingInt(i -> i.start));

        // Min-heap to keep track of end times
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add the end time of the first meeting
        minHeap.add(intervals.get(0).end);

        // Start from the second interval
        for (int i = 1; i < intervals.size(); i++) {
            // If the room is free (the earliest ending meeting ended)
            if (intervals.get(i).start >= minHeap.peek()) {
                minHeap.poll(); // free the room
            }
            // Allocate a room (add current meeting's end time)
            minHeap.add(intervals.get(i).end);
        }

        // Number of rooms is the size of the heap
        return minHeap.size();
    }
}
