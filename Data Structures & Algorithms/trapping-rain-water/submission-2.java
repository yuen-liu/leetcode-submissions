class Solution {
    public int trap(int[] height) {
        // water[i] = Math.min(leftMax, rightMax) - height[i]
        // we make two arrays to keep track of local maxes for both left and right
        // then iterate thru height to add water to our total!

        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        int total = 0;

        if (height.length == 0) {
            return 0;
        }

        leftMax[0] = height[0];

        for (int i = 1; i < height.length; i++) {
            leftMax[i] = leftMax[i - 1];
            if (leftMax[i - 1] <= height[i]) {
                leftMax[i] = height[i];
            }
        }

        rightMax[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = rightMax[i + 1];
            if (rightMax[i + 1] <= height[i]) {       // is the current wall taller?
                rightMax[i] = height[i];
            }
        }

        for (int i = 0; i < height.length; i++) {
            int temp = Math.min(leftMax[i], rightMax[i]) - height[i];
            total += temp;
        }

        return total;
    
    }
}
