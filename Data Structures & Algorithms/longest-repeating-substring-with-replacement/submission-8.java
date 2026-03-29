class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] freq = new int[26];
        int maxfreq = 0;
        int windowlength = 0;
        int maxwindowlength = 0;
        int left = 0;

        for(int right = 0; right <= s.length()  - 1; right++){

            freq[s.charAt(right) - 'A']++;


            maxfreq = Math.max(freq[s.charAt(right) - 'A'], maxfreq);


            windowlength = right - left + 1;



            if(windowlength - maxfreq > k){
                // freq[s.charAt(right) - 'A']++;
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            windowlength = right - left + 1;

            maxwindowlength = Math.max(windowlength, maxwindowlength);


        }

        return maxwindowlength;
        
    }
}

/* 

main idea is windowlength - freq > k
*/