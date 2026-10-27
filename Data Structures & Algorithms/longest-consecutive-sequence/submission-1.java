class Solution {
    public int longestConsecutive(int[] nums) {
        // use a set
        Set<Integer> starts = new HashSet<>();
        for (int num : nums) {
            starts.add(num);
        }

        int longest = 0;
        for (int num : nums) {
            // only run if no prev consecutive numbers
            if (!starts.contains(num - 1)) {
                int curr = num;
                int streak = 0;
                while (starts.contains(curr)) {
                    curr++;
                    streak++;
                }
                longest = Math.max(longest, streak);
            }
        }

        return longest;

    }
}
