class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();

        for (String str : strs) {
            // make a key with sorted alphabetical order
            int[] arr = new int[26];
            char[] charArr = str.toCharArray();
            for (char c : charArr) {
                arr[c - 'a']++;
            }

            // convert int[] arr to a string so we can match content equality
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                builder.append(arr[i]);
                builder.append('#');
            }
            String key = builder.toString();

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
