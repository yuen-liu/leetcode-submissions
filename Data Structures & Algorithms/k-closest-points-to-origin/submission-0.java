class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // iterative method: runtime O(nlogn) and spacetime O(n)
        // max heap method: runtime O(nlogk) and spacetime O(k)
        PriorityQueue<int[]> maxheap = new PriorityQueue<>(
            (a, b) -> Integer.compare(b[0] * b[0] + b[1] * b[1],
            a[0] * a[0] + a[1] * a[1]));

        for (int[] point : points) {
            // we add the values
            maxheap.offer(point);
            if (maxheap.size() > k) {
                maxheap.poll(); // only the smallest distances kept
            }
        }

        int[][] res = new int[k][2];
        int i = 0;
        while (!maxheap.isEmpty()) {
            res[i++] = maxheap.poll();
        }
        return res;

    }
}
