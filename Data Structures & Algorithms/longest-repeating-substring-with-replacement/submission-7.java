class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] freq = new int[26];
        int windowlength = 0;
        int maxwindowlength = 0;
        int left = 0;
        int maxfreq = 0;
        int len = 0;

        for(int right = 0; right <= s.length() - 1; right++){
            // char c = s.charAt(right);
            freq[s.charAt(right) - 'A']++;


            maxfreq = Math.max(maxfreq, freq[s.charAt(right) - 'A']);

            windowlength = right - left + 1;


            if(windowlength - maxfreq > k){
                freq[s.charAt(left) - 'A']--;
                left++;
            }
                windowlength = right - left + 1;
            

            maxwindowlength = Math.max(maxwindowlength, windowlength);


        }

        return maxwindowlength;

        
    }
}
