class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int width = 0, height = 0, area = 0;

        int maxarea = 0;

        while (left < right) {
            width = right - left;
            height = Math.min(heights[left], heights[right]);
            area = width * height;

            if (heights[left] < heights[right]) {
                left++;
            } else if (heights[left] > heights[right]) {
                right--;
            } else {
                left++;
                right--;
            }

            if (area > maxarea) maxarea = area;
        }

        return maxarea;
    }
}
