class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // one way to do this (less optimal): hash maps
        // better way to do this: sliding window
        // two int[] arrays that keep track of s1 char count and s2 window
        // check: matches == 26 --> we stop!
        // as we iterate thru s2 make sure to update l and r chars

        if (s1.length() > s2.length()) return false; // edge case

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        int matches = 0;

        for (int i = 0; i < s1.length(); i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++; // init our two char counts
        }

        for (int i = 0; i < 26; i++) {
            if (count1[i] == count2[i]) {
                matches++;
            }
        }
        
        int l = 0;
        for (int r = s1.length(); r < s2.length(); r++) { // rest of s2 chars
            if (matches == 26) {
                return true; // permutation found! all s1 chars in s2 :)
            }

            // right char
            int index = s2.charAt(r) - 'a';
            count2[index]++;
            if (count1[index] == count2[index]) {
                matches++;
            } else if (count1[index] + 1 == count2[index]) {
                matches--;
            }

            // left char
            index = s2.charAt(l) - 'a';
            count2[index]--;
            if (count1[index] == count2[index]) {
                matches++;
            } else if (count1[index] - 1 == count2[index]) {
                matches--;
            }
            l++;

        }

        return matches == 26;

    }
}
