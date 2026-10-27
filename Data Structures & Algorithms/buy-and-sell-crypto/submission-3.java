class Solution {
    public int maxProfit(int[] prices) {
        // sliding window: find a subarray
        int left = 0;
        int right = 1;
        int max = 0;

        while (right < prices.length) {
            // sliding window: update max
            if (prices[left] < prices[right]) {
                int profit = prices[right] - prices[left];
                max = Math.max(profit, max);
            } else {
                // this means prices[right] is the new minimum
                left = right;
            }
            // always increment right so it's a dynamic window
            right++;
        }
        return max;
    }
}
