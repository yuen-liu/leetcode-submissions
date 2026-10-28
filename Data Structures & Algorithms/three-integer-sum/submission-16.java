class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // tl;dr - get all triplets where nums[i] + nums[j] + nums[k] = 0
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        // iterate thru nums and do two sum basically
        for (int i = 0; i < nums.length; i++) {
            // edge case: duplicate
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                // define target
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    // check for dups
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }

                    j++;
                    k--;
                }
            }
        }

        return res;
    }
}
