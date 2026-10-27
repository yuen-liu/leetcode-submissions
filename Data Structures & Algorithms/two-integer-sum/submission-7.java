class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] output = new int[2];

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target && i != j) {
                    output[0] = i;
                    output[1] = j;
                }
            }
        }

        if (output[0] > output[1]) {
            int temp = output[0];
            output[0] = output[1];
            output[1] = temp;
        }

        return output;
    }
}
