class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // O(n*2^n): decision tree (add or not add) and for loop
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        // call our helper method
        dfs(nums, 0, subset, res);
        return res;
    }

    private void dfs(int[] nums, int i, List<Integer> subset, List<List<Integer>> res) {
        // base case
        if (i >= nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]); // we are adding nums[i]
        dfs(nums, i + 1, subset, res);

        subset.remove(subset.size() - 1); // we are not adding nums[i]
        dfs(nums, i + 1, subset, res);
    }
}
