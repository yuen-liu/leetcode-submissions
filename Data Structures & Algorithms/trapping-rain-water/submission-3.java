class Solution {
    public int trap(int[] height) {
        // return total amount of water trapped btw bars
        // water[i] = min(leftmax[i], rightmax[i])

        // non-optimal soln: do O(n^2) and iterate twice so we calculate the leftmax and right max of each index
        // O(n) soln: use two arrays to keep track of our leftmax and rightmax

        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        int total = 0;

        // init our leftMax array
        leftMax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        // init our rightMax array
        rightMax[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        // now calculate trapped water at every index and add to total
        for (int i = 0; i < height.length; i++) {
            total += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return total;
    }
}
