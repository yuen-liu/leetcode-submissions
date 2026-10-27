class Solution {
    public int[] productExceptSelf(int[] nums) {
        int pdt = 1;
        int zerocount = 0;
        for (int num : nums) {
            if (num == 0) {
                zerocount++;
            } else {
                pdt *= num;
            }
        }
        if (zerocount > 1) {
            pdt = 0;
            return new int[nums.length];
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                res[i] = pdt;
            } else {
                if (zerocount == 1) {
                    res[i] = 0;
                } else {
                    res[i] = pdt / nums[i];
                }
            }
        }
        return res;
    }
}  
