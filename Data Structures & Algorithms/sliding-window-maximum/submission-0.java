class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // three ways to do this:
        // 1. brute force 2. maxheap 3. sliding window
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> q = new LinkedList<>();
        int l = 0, r = 0;

        while (r < n) {
            // remove the last element of our queue (smallest)
            while (!q.isEmpty() && nums[q.getLast()] < nums[r]) {
                q.removeLast();
            }
            
            // add our new index on right
            q.addLast(r);

            // remove the previous local max if out of bounds
            if (l > q.getFirst()) {
                q.removeFirst();
            }

            // update the results
            if ((r + 1) >= k) {
                res[l] = nums[q.getFirst()];
                l++;
            }

            r++;
        }

        return res;
    }
}
