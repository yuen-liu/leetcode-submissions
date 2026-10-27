class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numset = new HashSet<>();

        for (int num : nums) {
            numset.add(num);
        }

        int res = 0;

        for (int num : numset) {
            if (!numset.contains(num-1)) {
                // start
                int len = 1;
                while (numset.contains(num + len)) {
                    len++;
                }
                res = Math.max(res, len);
            }
        }

        return res;
    }
}
