class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // make hashmap where key = sorted word and
        // val = list of anagrams
        Map<String, List<String>> anagrams = new HashMap<>();

        // for every word in strs
        // sort each word
        for (String word : strs) {
        // if the sorted word is not in map --> put in.
        // else --> get the key and add word to value
        int[] temp = new int[26];
        for (char ch : word.toCharArray()) {
            temp[ch - 'a']++;
        }
        String key = Arrays.toString(temp);
        anagrams.putIfAbsent(key, new ArrayList<>());
        anagrams.get(key).add(word);
        }

        // return map
        return new ArrayList<>(anagrams.values());
    }
}
