class Solution {
    public int lengthOfLongestSubstring(String s) {
        // return the length of the longest substring in s w/o dups
        // most optimal solution - O(n)

        // hashset seen
        // brute force: two for loops - O(n * m)
        // sliding window: only keep non-dup valid substrings
        // length of substring: r - l + 1

        HashSet<Character> seen = new HashSet<>();
        int l = 0;
        int len = 0;

        for (int r = 0; r < s.length(); r++) {
            while (seen.contains(s.charAt(r))) {
                // update the sliding window
                seen.remove(s.charAt(l));
                l++;
            }

            seen.add(s.charAt(r));

            len = Math.max(len, r - l + 1);
        }

        return len;
    }
}
