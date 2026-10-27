class Solution {
    public int missingNumber(int[] nums) {
        // the xor operation: only returns the nums if by 0
        // also returns 0 if num xor num

        int xor = nums.length; // initialize to length
        // bc for loop only goes from 0 to nums.length - 1

        for (int i = 0; i < nums.length; i++) {
            // i & nums[i] should ideally return 0 if dups
            // else xor will xor to missing index i
            xor ^= i ^ nums[i]; 
        }

        return xor;
    }
}
