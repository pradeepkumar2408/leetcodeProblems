class MedianFinder {
    PriorityQueue<Integer> maxheap;
     PriorityQueue<Integer> minheap;
    boolean flag = true;
    public MedianFinder() {
        minheap = new PriorityQueue<>();
        maxheap = new PriorityQueue<>((a,b) -> b.compareTo(a));
    }
    
    public void addNum(int num) {
        if(flag){
            maxheap.add(num);
        }else
            minheap.add(num);

        if(!minheap.isEmpty() && maxheap.peek() > minheap.peek()){
            int a = maxheap.poll();
            int b = minheap.poll();

            minheap.add(a);
            maxheap.add(b);
        }

        flag = !flag;
    }
    
    public double findMedian() {
        if(minheap.size() == maxheap.size())
            return (minheap.peek() + maxheap.peek()) / 2.0;
        return maxheap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */