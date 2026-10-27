class Solution {
    public int maxProfit(int[] prices) {
        // choose one day to buy
        // diff day in the future to sell (needs to be after og day)
        // return max profit
        int profit = 0;
        int max = 0;
        int l = 0;
        int r = 1;

        while (r < prices.length) {
            if (prices[l] < prices[r]) {
                profit = prices[r] - prices[l];
                max = Math.max(profit, max);
            } else {
                l = r;
            }
            r++;
            max = Math.max(profit, max);
        }


        return max;
    }
}
