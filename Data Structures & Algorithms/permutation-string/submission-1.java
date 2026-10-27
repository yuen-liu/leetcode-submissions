class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // brute force: O(n^2) check for s1 in s2
        // optimal soln: O(n) use sliding window + 2 arrays

        // automatically false if s1 > s2
        if (s1.length() > s2.length()) return false;

        int[] freq1 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            freq1[c - 'a']++;
        }

        int left = 0;
        int[] freq2 = new int[26];
        for (int right = 0; right < s2.length(); right++) {
            char c = s2.charAt(right);
            freq2[c - 'a']++;

            // make sure that the int arr sizes are same
            while(right - left + 1 > s1.length()) {
                freq2[s2.charAt(left) - 'a']--;
                left++;
            }

            // if sliding window int arr same as str1
            if (Arrays.equals(freq1, freq2)) return true;
        }

        return false;
        
    }
}
