class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[nums.length];
        int[] pref = new int[nums.length];
        int[] suff = new int[nums.length];

        pref[0] = 1;
        suff[n-1] = 1;

        for (int i = 1; i < n; i++) {
            pref[i] = nums[i - 1] * pref[i - 1];
        }

        for (int i = n - 2; i >= 0; i--) {
            suff[i] = nums[i + 1] * suff[i + 1];
        }

        for (int i = 0; i < n; i++) {
            res[i] = pref[i] * suff[i];
        }

        return res;
    }
}  
