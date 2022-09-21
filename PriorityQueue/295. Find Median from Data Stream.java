class MedianFinder {
    private PriorityQueue<Integer> firstHalfDescendingPQ = new PriorityQueue<>((a, b) -> (b - a));
    private PriorityQueue<Integer> secondHalfAscendingPQ = new PriorityQueue<>((a, b) -> (a - b));
    

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        firstHalfDescendingPQ.offer(num);
        secondHalfAscendingPQ.offer(firstHalfDescendingPQ.poll());
        if (secondHalfAscendingPQ.size() > firstHalfDescendingPQ.size()) {
            firstHalfDescendingPQ.offer(secondHalfAscendingPQ.poll());
        }
    }
    
    public double findMedian() {
        if (firstHalfDescendingPQ.size() > secondHalfAscendingPQ.size()) {
            return (double)firstHalfDescendingPQ.peek();
        }
        return (double)(firstHalfDescendingPQ.peek() + secondHalfAscendingPQ.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
