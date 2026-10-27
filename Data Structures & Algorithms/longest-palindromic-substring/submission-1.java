class Solution {
    public String longestPalindrome(String s) {
        int reslen = 0, residx = 0;

        for (int i = 0; i < s.length(); i++) {
            // odd length
            int l = i, r = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                // valid palindrome
                if (r - l + 1 > reslen) {
                    residx = l;
                    reslen = r - l + 1;
                }
                l--;
                r++; // keep moving the pointers
            }

            // even length
            l = i;
            r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > reslen) {
                    residx = l;
                    reslen = r - l + 1;
                }
                l--;
                r++;
            }
        }

        return s.substring(residx, residx + reslen);
    }
}
