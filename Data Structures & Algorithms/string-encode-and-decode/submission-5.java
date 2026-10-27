class Solution {

    public String encode(List<String> strs) {
        StringBuilder code = new StringBuilder();

        for (String str : strs) {
            code.append(str.length());
            code.append("#");
            code.append(str);
        }

        String codestr = code.toString();

        return codestr;
    }

    public List<String> decode(String codestr) {
        List<String> decode = new ArrayList<String>();

        int i = 0;
        
        while (i < codestr.length()) {
            int j = i;
            while (codestr.charAt(j) != '#') {
                j++;
            }
            int len = Integer.parseInt(codestr.substring(i, j));
            j++;
            decode.add(codestr.substring(j, j + len));
            i = j + len;
        }

        return decode;
    }
}
