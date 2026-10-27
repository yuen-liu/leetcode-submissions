class KthLargest {
    private PriorityQueue<Integer> minheap;
    private int k;
    // we can make a minheap and any time
    // minheap's size > k we poll

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minheap = new PriorityQueue();
        for (int num : nums) {
            minheap.offer(num);

            if (minheap.size() > k) {
                minheap.poll();
            }
        }

    }
    
    public int add(int val) {
        minheap.offer(val);
        if (minheap.size() > k) {
            minheap.poll();
        }
        return minheap.peek();
    }
}
