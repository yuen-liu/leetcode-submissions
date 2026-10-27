class Solution {
    public int[] twoSum(int[] nums, int target) {
        // nums[i] + nums[j] == target 
        // i != j

        // dumb way to do this is with a nested for loop
        // smarter way: one hashset with vals of nums
        // iterate thru nums --> check if hashset contains
        // target - nums[i]

        int[] result = new int[2];

        HashMap<Integer, Integer> vals = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (vals.containsKey(target - nums[i])) {
                result[0] = vals.get(target - nums[i]);
                result[1] = i;
                return result;
            }

            vals.put(nums[i], i);
        }

        return result;

    }
}
