class Solution {
    public boolean isPalindrome(String s) {
        // palindrome: string that reads the same forward & backward
        // case insensitive + ignores all non-alphanumeric chars
        
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                str.append(Character.toLowerCase(s.charAt(i)));
            }
        }

        return (str.toString().equals(str.reverse().toString()));

    }
}
