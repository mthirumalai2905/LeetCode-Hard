class MedianFinder {
    public PriorityQueue<Integer> left_max_heap;
    public PriorityQueue<Integer> right_min_heap;

    public MedianFinder() {
        left_max_heap = new PriorityQueue<>(Collections.reverseOrder()); // Max heap for left side
        right_min_heap = new PriorityQueue<>(); // Min heap for right side
    }
    
    public void addNum(int num) {
        if (left_max_heap.isEmpty() || num <= left_max_heap.peek()) {
            left_max_heap.add(num);
        } else {
            right_min_heap.add(num);
        }

        if (left_max_heap.size() > right_min_heap.size() + 1) {
            right_min_heap.add(left_max_heap.poll());
        } else if (right_min_heap.size() > left_max_heap.size()) {
            left_max_heap.add(right_min_heap.poll());
        }
    }
    
    public double findMedian() {
        if (left_max_heap.isEmpty()) {
            throw new RuntimeException("No numbers added.");
        }

        if (left_max_heap.size() > right_min_heap.size()) {
            return left_max_heap.peek();
        } else {
            return (left_max_heap.peek() + right_min_heap.peek()) / 2.0;
        }
    }
}

