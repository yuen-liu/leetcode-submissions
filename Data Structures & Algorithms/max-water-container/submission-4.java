class Solution {
    public int maxArea(int[] heights) {
        // one way to solve this (brute force): iterate twice
        // which would have O(n^2) runtime
        // optimal soln: O(n) runtime
        int left = 0;
        int right = heights.length - 1;
        int max = 0;

        while (left < right) {
            int area = (right - left) * (Math.min(heights[left], heights[right]));
            if (heights[left] < heights[right]) {
                left++;
            } else if (heights[left] > heights[right]) {
                right--;
            } else {
                left++;
                right--;
            }
            max = Math.max(area, max);
        }

        return max;
        
    }
}
