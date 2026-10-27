class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();


        for (int i = 0; i < strs.length; i++) {
            char[] charArr = strs[i].toCharArray();
            int[] key = new int[26];

            for (char c : charArr) {
                key[c - 'a']++;
            }

            StringBuilder sortkey = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                sortkey.append(key[j]);
                sortkey.append('#');
            }
            String sorted = sortkey.toString();

            map.computeIfAbsent(sorted, k -> new ArrayList<>()).add(strs[i]);
        }

        return new ArrayList<>(map.values());
    }
}
