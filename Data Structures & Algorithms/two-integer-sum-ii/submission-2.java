class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        
        while (l < r) {
            int current = numbers[l] + numbers[r];

            if (current > target) {
                r--;
            } else if (current < target) {
                l++;
            } else {
                return new int[] { l + 1, r + 1};
            }
        }
        return new int[0];
    }
}
