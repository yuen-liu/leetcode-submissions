class Solution {
    public int longestConsecutive(int[] nums) {
        // first identify what the starts are
        // then go through and make the chains


        HashSet<Integer> set = new HashSet<Integer>();
        int res = 0;

        for (int num : nums) {
            set.add(num);
        }

        for (int num : set) {
            int count = 0;
            if (!set.contains(num - 1)) { // num is a start
                while (set.contains(num + count)) {
                    count++;
                }
            }
            if (count > res) {
                res = count;
            }
        }

        return res;
    }
}
