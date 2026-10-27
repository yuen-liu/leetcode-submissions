class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            
            int[] sort = new int[26];
            for (char c : charArray) {
                sort[c - 'a']++;
            }

            StringBuilder sortkey = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sortkey.append(sort[i]);
                sortkey.append('#');
            }
            String sorted = sortkey.toString();
            // Arrays.sort(charArray);
            // String sorted = new String(charArray);
            map.computeIfAbsent(sorted, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());

    }
}
