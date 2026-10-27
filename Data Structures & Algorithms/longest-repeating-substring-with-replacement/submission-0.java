class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int maxFreq = 0;
        int maxLength = 0;
        int[] charCount = new int[26]; // Only uppercase letters A-Z
        
        for (int right = 0; right < s.length(); right++) {
            // Expand window - add right character
            charCount[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, charCount[s.charAt(right) - 'A']);
            
            // Check if window is valid
            int windowSize = right - left + 1;
            if (windowSize - maxFreq > k) {
                // Shrink window - remove left character
                charCount[s.charAt(left) - 'A']--;
                left++;
            }
            
            // Update max length (window is guaranteed valid here)
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}
