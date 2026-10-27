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
        ArrayList<String> strs = new ArrayList<>();
        int l = 0, r = 0, size = 0;
        while (r != str.length()) {
            while (str.charAt(r) != '#') {
                r++;
            }
            size = Integer.parseInt(str.substring(l, r));
            l = r + 1;
            strs.add(str.substring(l, l + size));
            l = l + size;
            r = l;
        }

        return strs;
    }
}
