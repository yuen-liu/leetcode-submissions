class Solution {
    public int characterReplacement(String s, int k) {
        // sliding window approach:
        // expand right pter upward in loop
        // while loop: shrink from the left when condition violated

        int l = 0;
        int res = 0;
        int count = 0;
        HashMap<Character, Integer> mp = new HashMap<>();

        for (int r = 0; r < s.length(); r++) {
            int temp = 0;
            mp.put(s.charAt(r), mp.getOrDefault(s.charAt(r), 0) + 1);
            count = Math.max(count, mp.get(s.charAt(r)));

            if (((r - l + 1) - count > k)) { // condition broken
                mp.put(s.charAt(l), mp.get(s.charAt(l)) - 1);
                l++;
            }

            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
