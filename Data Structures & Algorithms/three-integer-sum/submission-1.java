class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // new list results
        List<List<Integer>> res = new ArrayList<>();

        // sort nums
        Arrays.sort(nums);

        // iterate through nums
        for (int i = 0; i < nums.length; i++) {
            // break if nums[0] > 0
            if (i == 0 && nums[i] > 0) {
                break;
            }
            
            // skip if duplicates
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum > 0) {
                    r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    // no duplicates
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                }
            }
        }

        return res;
    }
}
