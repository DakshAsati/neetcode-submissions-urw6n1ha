class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26]; // To store frequency of each character in window
        int maxFreq = 0; // Max frequency of a single character in the window
        int left = 0; // Left pointer of the window
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'A']++; // Increase count of right character
            maxFreq = Math.max(maxFreq, count[s.charAt(right) - 'A']);

            // If more than k replacements are needed, shrink the window
            if ((right - left + 1) - maxFreq > k) {
                count[s.charAt(left) - 'A']--; // Remove leftmost char from window
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
