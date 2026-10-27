class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buy = prices[0];

        for (int i = 0; i < prices.length; i++) {
            int sell = prices[i];
            profit = Math.max(profit, sell - buy);
            buy = Math.min(buy, sell);
        }
        
        return profit;
    }
}
