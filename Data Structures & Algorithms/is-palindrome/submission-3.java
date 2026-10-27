class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder forward = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                forward.append(Character.toLowerCase(c));
            }
        }
        return (forward.toString().equals(forward.reverse().toString()));
    }
}
