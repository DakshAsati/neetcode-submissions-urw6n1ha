class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int n = queries.length;
        int[] res = new int[n];

        // Save original query indices
        int[][] qWithIdx = new int[n][2];
        for (int i = 0; i < n; i++) {
            qWithIdx[i][0] = queries[i];
            qWithIdx[i][1] = i;
        }
        Arrays.sort(qWithIdx, (a, b) -> a[0] - b[0]);

        // MinHeap: (interval length, right bound)
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> a.distance - b.distance);

        int idx = 0; // interval pointer
        for (int[] q : qWithIdx) {
            int query = q[0], qIndex = q[1];

            // add all intervals starting <= query
            while (idx < intervals.length && intervals[idx][0] <= query) {
                int length = intervals[idx][1] - intervals[idx][0] + 1;
                minHeap.add(new Pair(length, intervals[idx][1]));
                idx++;
            }

            // remove intervals that end < query
            while (!minHeap.isEmpty() && minHeap.peek().right < query) {
                minHeap.poll();
            }

            res[qIndex] = minHeap.isEmpty() ? -1 : minHeap.peek().distance;
        }

        return res;
    }

    class Pair {
        int distance;
        int right;
        Pair(int distance, int right) {
            this.distance = distance;
            this.right = right;
        }
    }
}
