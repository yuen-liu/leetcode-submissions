class Solution {
    public String minWindow(String s, String t) {
        // brute force this: iterate through with a new hash map for each unique character in t
        // more optimal soln: use a sliding window to keep track of possible substrings
        // and shortest len!
        // we can use two hash maps - 1 to record string s's counts; 1 for t's window counts
        // compare: if have and need are the same!

        // edge case
        if (s.length() < t.length()) return "";

        // init our s hash map
        HashMap<Character, Integer> tcount = new HashMap<>();
        for (char c : t.toCharArray()) {
            tcount.put(c, tcount.getOrDefault(c, 0) + 1);
        }

        int len = Integer.MAX_VALUE; // check to keep track of whether or not we have a soln!
        String sub = "";
        int have = 0, need = tcount.size(), l = 0;

        HashMap<Character, Integer> window = new HashMap<>(); // init our sliding window s map
        for (int r = 0; r < s.length(); r++) { // iterate thru s
            char rval = s.charAt(r);
            window.put(rval, window.getOrDefault(rval, 0) + 1);

            if (tcount.containsKey(rval) && window.get(rval).equals(tcount.get(rval))) {
                have++; // increment the have count if match!
            }

            while (have == need) { // case where we have a soln!
                if ((r - l + 1) < len) {
                    len = r - l + 1;
                    sub = s.substring(l, r + 1); // update: curr window is shorter than prev 
                }

                char lval = s.charAt(l); //  only move l if soln found!
                window.put(lval, window.getOrDefault(lval, 0) - 1);

                if (tcount.containsKey(lval) && window.get(lval) < tcount.get(lval)) {
                    have--;
                }

                l++;
            }
        }

        return sub;
        
    }
}
