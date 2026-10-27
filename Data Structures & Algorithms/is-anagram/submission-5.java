class Solution {
    public boolean isAnagram(String s, String t) {
        // length
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> s_seen = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            s_seen.put(c, s_seen.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (!s_seen.containsKey(c)) {
                return false;
            }
            s_seen.put(c, s_seen.get(c) - 1);
            if (s_seen.get(c) == 0) {
                s_seen.remove(c);
            }
        }

        // If all characters are accounted for, the map should be empty
        

        return s_seen.isEmpty();


    }
}
