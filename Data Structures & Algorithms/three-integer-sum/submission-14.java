class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // return ALL triplets [nums[i], nums[j], nums[k]]
        // where nums[i] + nums[j] + nums[k] == 0
        // and indices i, j, and k are all distinct

        // brute force soln: 3 for loops --> keep track of every single triplet. 
        // O(N^3) soln...
        // better soln: sliding window!
        // first sort the array
        // then do O(N^2) soln?
        // l, m, r (3 pointers)
        
        List<List<Integer>> res = new ArrayList<>();

        int l = 0;

        Arrays.sort(nums);

        // iterate thru nums
        // check if -nums[l] = nums[m] + nums[r]

        for (int i = 0; i < nums.length - 1; i++) {
            int m = i + 1;
            int r = nums.length - 1;

            int target = -nums[i];
            while (m < r && i != m && i != r) {
                int sum = nums[m] + nums[r];

                if (sum < target) { // increment m
                    m++;
                } else if (sum > target) {
                    r--;
                } else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[m]);
                    temp.add(nums[r]);

                    if (!res.contains(temp)) {
                        res.add(temp);
                    }

                    m++;
                    r--;
                }

            }
        }

        return res;

    }
}
