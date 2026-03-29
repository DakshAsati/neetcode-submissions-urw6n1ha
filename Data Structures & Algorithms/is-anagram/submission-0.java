class Solution {
    public boolean isAnagram(String s, String t) {

        
        char[] st = s.toCharArray();
        char[] tt = t.toCharArray();

       Arrays.sort(st);
       Arrays.sort(tt);

        boolean result = Arrays.equals(st,tt);
        return result;

        

    }
}
