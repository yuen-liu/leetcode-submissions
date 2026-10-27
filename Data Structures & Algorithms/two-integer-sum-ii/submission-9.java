class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        // indices ad up to target; index1 < index2
        int l = 0;
        int r = numbers.length - 1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum > target) {
                r--;
            } else if (sum < target) {
                l++;
            } else {
                res[0] = l + 1;
                res[1] = r + 1;
                return res;
            }
        }
        return res;

    }
}
