class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int totalpdt = 1;
        int zero = 0;
        for (int num : nums) {
            if (num != 0) {
                totalpdt *= num;
            } else {
                zero++;
            }
        }

        if (zero > 1) {
            return res;
        }

        for (int i = 0; i < nums.length; i++) {
            if (zero > 0) {
                res[i] = (nums[i] == 0) ? totalpdt : 0;
            } else {
                res[i] = totalpdt / nums[i];
            }
        }
        return res;
    }
}  
