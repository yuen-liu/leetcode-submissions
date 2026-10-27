class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // O(n * 2^n)
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        // call our helper function
        dfs(0, nums, subset, res);
        return res;
    }

    private void dfs(int index, int[] nums, List<Integer> subset, List<List<Integer>> res) {
        // base case: reach the end of our array (no more choices to be made)
        if (index >= nums.length) { 
            res.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[index]); // choice: add nums[i]
        dfs(index + 1, nums, subset, res);
        subset.remove(subset.size() - 1); // choice: do not add nums[i]
        dfs(index + 1, nums, subset, res);
    }
}
