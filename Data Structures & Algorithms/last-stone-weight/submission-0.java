class Solution {
    public int lastStoneWeight(int[] stones) {
        // use a queue!
        PriorityQueue<Integer> minheap = new PriorityQueue<>();

        for (int stone : stones) {
            minheap.offer(-stone); // maxheap
        }

        while (minheap.size() > 1) {
            int first = minheap.poll();
            int second = minheap.poll();
            if (second > first) {
                minheap.offer(first - second);
            }
        }

        minheap.offer(0);
        return Math.abs(minheap.peek());

    }
}
