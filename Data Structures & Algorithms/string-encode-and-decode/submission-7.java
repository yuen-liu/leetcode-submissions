class Solution {

    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for (String str : strs) {
            res.append(str.length());
            res.append("#");
            res.append(str);
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        ArrayList<String> res = new ArrayList<String>();
        
        int i = 0;

        while (i < str.length()) {
            int j = i;

            while (str.charAt(j) != '#') {
                j++; // j is now at the end of the string length
            }

            int len = Integer.parseInt(str.substring(i, j));
            j++;

            String word = str.substring(j, j + len);
            i = j + len;
            res.add(word);

        }

        return res;
    }
}
