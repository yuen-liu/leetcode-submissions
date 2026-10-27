class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];

        int pdt = 1, zero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                pdt *= nums[i];
            } else {
                zero++;
            }
        }

        if (zero > 1) {
            return output;
        }

        for (int i = 0; i < nums.length; i++) {
            if (zero > 0) {
                output[i] = (nums[i] == 0) ? pdt : 0;
            } else {
                output[i] = pdt / nums[i];
            }
        }

        return output;
    }
}  
