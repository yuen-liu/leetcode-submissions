class Solution {
    public int maxProfit(int[] prices) {
        // two ways to do this
        // non optimal: 2 loops: calculate the maximum profit each time and update
        // optimal O(N): use a sliding window approach!
        // keep track of the lowest price with left pointer
        // and the highest price with the right pointer

        int l = 0, r = 1;
        int max = 0;

        while (r < prices.length) {
            int profit = prices[r] - prices[l];

            if (profit > max) {
                max = profit;
            }

            if (prices[l] > prices[r]) {
                l = r;
            } else {
                r++;
            }
            
        }

        return max;
    }
}
