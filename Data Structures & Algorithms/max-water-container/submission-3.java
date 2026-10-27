class Solution {
    public int maxArea(int[] heights) {
        // two pointers
        int l = 0, r = heights.length - 1;

        // final area
        int fin_area = 0;
        while (l < r) {
            int temp_area = Math.min(heights[l], heights[r]) * (r - l);
            fin_area = Math.max(fin_area, temp_area);
            if (heights[l] <= heights[r]) {
                l++;
            } else {
                r--;
            }
        }

        return fin_area;
    }
}
