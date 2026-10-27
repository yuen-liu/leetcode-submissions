class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26]; // 26 dif chars
        for (char task : tasks) {
            count[task - 'A']++; // keep track of counts
        }

        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        for (int cnt : count) {
            if (cnt > 0) {
                maxheap.add(cnt); // add valid counts to maxheap
            }
        }

        int time = 0;
        Queue<int[]> q = new LinkedList<>(); // queue to know when we add
        while (!maxheap.isEmpty() || !q.isEmpty()) {
            time++; // time always goes up

            if (maxheap.isEmpty()) {
                time = q.peek()[1]; // we can go to the queue now
            } else {
                int cnt = maxheap.poll() - 1; // just put a cpu in
                if (cnt > 0) {
                    q.add(new int[]{cnt, time + n}); // add remaining vals to queue
                }
            }

            if (!q.isEmpty() && q.peek()[1] == time) { // re-add to heap
                maxheap.add(q.poll()[0]); // 
            }
        }

        return time;
    }
}
