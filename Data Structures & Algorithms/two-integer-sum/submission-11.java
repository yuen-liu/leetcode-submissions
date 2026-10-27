class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] arr = new int[2];

        // complements
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                arr[1] = i;
                arr[0] = map.get(diff);
                return arr;
            } else {
                map.put(nums[i], i);
            }
        }

        return arr;


    }
}
