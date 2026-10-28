class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // sorted in ascending order
        // return indices (1-indexed) of two numbers [index1, index2]
        // index1 < index2 && numbers[index1] + numbers[index2] == target

        // brute force:
        // two loops: O(N^2)
        // but since we can only use O(1) additional space we can use two pointers
        // small number + large number = target theoretically

        int l = 0;
        int r = numbers.length - 1;

        int[] res = new int[2];

        while (l < r && l != r) {
            int sum = numbers[l] + numbers[r];

            if (sum < target) {
                // increment left pointer -> get a bigger 'small' num
                l++;
            } else if (sum > target) {
                r--;
            } else {
                res[0] = l + 1;
                res[1] = r + 1;
                break;
            }
            
        }

        return res;
    }
}
