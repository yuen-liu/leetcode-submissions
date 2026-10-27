class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int max = 0, l = 0, r = height.length - 1;
        int leftMax = height[l], rightMax = height[r];
        while (l < r) {
            if (leftMax < rightMax) {
                l++;
                leftMax = Math.max(leftMax, height[l]);
                max += leftMax - height[l];
            } else {
                r--;
                rightMax = Math.max(rightMax, height[r]);
                max += rightMax - height[r];
            }
        }

        return max;
    }
}
