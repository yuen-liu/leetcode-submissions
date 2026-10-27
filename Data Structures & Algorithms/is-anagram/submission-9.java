class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> scount = new HashMap<>();
        HashMap<Character, Integer> tcount = new HashMap<>();


        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            scount.put(c, scount.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            tcount.put(c, tcount.getOrDefault(c, 0) + 1);
        }

        if (scount.equals(tcount)) {
            return true;
        } else {
            return false;
        }

    }
}
