class Solution {
    public int lengthOfLongestSubstring(String s) {
        // goal: find length of longest substring w/o dup chars
        // brute force: 2 loops (or 3??) def O(n^2)/O(n^3)...
        // better soln: sliding window
        // keep track of substrings --> switch pointers to new substring
        // if there's a duplicate character

        // edge case: s is empty
        if (s.length() == 0) return 0;

        HashSet<Character> seen = new HashSet<>();
        int l = 0;
        int r = 1;
        int longest = 1;

        seen.add(s.charAt(l));

        while (r < s.length()) {
            while (seen.contains(s.charAt(r)) && l < r) {
                seen.remove(s.charAt(l));
                l++;
            }

            seen.add(s.charAt(r));

            longest = Math.max(r - l + 1, longest);

            r++;

        }

        return longest;
    }
}
