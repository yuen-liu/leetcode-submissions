class Solution {
    public int countSubstrings(String s) {
        // two solns: 1) brute force and check every substring
        // 2) two pointers: move outward with left and right
        // keep track of both odd and even length cases
        // update res
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int l = i, r = i;
            // odd case: l = r, same center
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                res++;
                l--;
                r++;
            }

            l = i;
            r = i + 1;
            // even case: r = l + 1, two centers
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                res++;
                l--;
                r++;
            }
        }
        return res;
    }
}
