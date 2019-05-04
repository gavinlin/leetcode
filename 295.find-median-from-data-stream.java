class MedianFinder {

    private PriorityQueue<Long> left, right;

    /** initialize your data structure here. */
    public MedianFinder() {
        left = new PriorityQueue<>();
        right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        right.add((long)num);
        left.add(-right.poll());
        if (right.size() < left.size()) {
            right.add(-left.poll());
        }
    }
    
    public double findMedian() {
        int count = left.size() + right.size();
        if (count % 2 == 1) return right.peek();
        return (right.peek() - left.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
