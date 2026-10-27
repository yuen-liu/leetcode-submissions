class Solution {
    public int lengthOfLongestSubstring(String s) {
        // sliding window: we need to find optimal substring

        int left = 0;
        int right = 0;
        int len = 0;
        int max = 0;
        HashSet<Character> seen = new HashSet<>();

        while (right < s.length()) {
            char c = s.charAt(right);
            // two cases: c is either in the set or not in the set
            if (!seen.contains(c)) { // len can be updated
                len = right - left + 1;
                max = Math.max(max, len);
            } else {
                // increment l until we reach non duplicate
                // also update hashset
                while (seen.contains(c)) {
                    seen.remove(s.charAt(left));
                    left++;
                }
            }
            // always increment r and add c to hashset
            right++;
            seen.add(c);
        }
        
        return max;
        
    }
}
