class Solution {
    public int trap(int[] height) {
        // height is empty --> return;
        if (height == null || height.length == 0) {
            return 0;
        }

        // pointers
        int l = 0, r = height.length - 1;
        int max = 0;
        int leftMax = height[l], rightMax = height[r];

        // iterate through
        while (l < r) {
            if (height[l] < height[r]) {
                l++;
                leftMax = Math.max(leftMax, height[l]);
                max += leftMax - height[l];
            } else {
                r--;
                rightMax = Math.max(rightMax, height[r]);
                max += rightMax - height[r];
            }
        }

        // return area
        return max;
    }
}
