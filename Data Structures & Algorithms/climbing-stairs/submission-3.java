class Solution {
    public int climbStairs(int n) {
        int one = 1, two = 1; // ways to reach curr and prev steps
        // base case

        for (int i = 0; i < n - 1; i++) {
            int temp = one;
            one = one + two; // new ways
            two = temp;
        }
        
        return one;
    }
}
