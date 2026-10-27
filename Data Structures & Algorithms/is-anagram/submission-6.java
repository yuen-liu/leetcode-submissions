class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> scount = new HashMap<Character, Integer>();
        HashMap<Character, Integer> tcount = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
            scount.put(s.charAt(i), scount.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            tcount.put(t.charAt(i), tcount.getOrDefault(t.charAt(i), 0) + 1);
        }

        return (scount.equals(tcount));

    }
}
