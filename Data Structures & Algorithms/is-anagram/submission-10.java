class Solution {
    public boolean isAnagram(String s, String t) {
        // given two strings s & t
        // return true if they are anagrams
        // else return false
        
        int[] sarr = new int[26];
        int[] tarr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            sarr[c - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            tarr[c - 'a']++;
        }

        return (Arrays.equals(sarr, tarr));

    }
}
