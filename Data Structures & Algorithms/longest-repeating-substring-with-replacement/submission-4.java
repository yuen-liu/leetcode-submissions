class Solution {
    public int characterReplacement(String s, int k) {
        // sliding window
        int left = 0;
        int res = 0;
        int maxfreq = 0; // to help us find how many replacements we have
        HashMap<Character, Integer> map = new HashMap<>();

        // for loop with pointer right
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            // put count into map
            map.put(c, map.getOrDefault(c, 0) + 1);
            maxfreq = Math.max(maxfreq, map.get(c));

            // if there are too many replacements
            while ((right - left + 1) - maxfreq > k) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++; // move left pointer up
            }

            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
