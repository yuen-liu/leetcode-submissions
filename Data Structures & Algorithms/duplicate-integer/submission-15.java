class Solution {
    public boolean hasDuplicate(int[] nums) {
        // return true if any val appears >1 in array
        // else return false
        // keep a hash set of nums that we have visited
        // and check each time if num is in hash set

        HashSet<Integer> seen = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (seen.contains(nums[i])) return true;
            seen.add(nums[i]);
        }

        return false;
    }
}