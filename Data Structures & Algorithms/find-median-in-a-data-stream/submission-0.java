
class MedianFinder {
    private PriorityQueue<Integer> left;  // Max-heap
    private PriorityQueue<Integer> right; // Min-heap

    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // Step 1: Add to max-heap (left)
        left.add(num);

        // Step 2: Balance - move the largest from left to right
        right.add(left.poll());

        // Step 3: Ensure left has equal or 1 more than right
        if (left.size() < right.size()) {
            left.add(right.poll());
        }
    }

    public double findMedian() {
        if (left.size() == right.size()) {
            return (left.peek() + right.peek()) / 2.0;
        } else {
            return left.peek();
        }
    }
}
