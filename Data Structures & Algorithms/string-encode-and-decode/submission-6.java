class Solution {

    public String encode(List<String> strs) {
        StringBuilder code = new StringBuilder();

        for (String str : strs) {
            code.append(str.length());
            code.append('#');
            code.append(str);
        }

        return code.toString();
    }

    public List<String> decode(String str) {
        // ex: "3#cat", "4#bode", "12#asdfg..."
        List<String> res = new ArrayList<String>();
        // need two pointers
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int len = Integer.parseInt(str.substring(i, j));
            j++;
            res.add(str.substring(j, j + len));
            i = j + len;
        }
        return res;
    }
}
