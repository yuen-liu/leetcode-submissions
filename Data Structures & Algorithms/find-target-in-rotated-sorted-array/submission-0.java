class Solution {
    public int search(int[] nums, int target) {
        // o(n) soln is to iterate through and search
        // o(logn) soln is to binary search

        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int m = (l + r) / 2;
            int mid = nums[m];
            if (target == mid) return m;

            // left sorted array
            if (nums[l] <= mid) {
                if (target > mid || target < nums[l]) { // there's more pivots
                    l = m + 1;
                } else { // target is less than mid so it's in the left sorted array
                    r = m - 1;
                }
            } else { // right sorted array
                if (target < mid || target > nums[r]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }

        }

        return -1;
    }
}
