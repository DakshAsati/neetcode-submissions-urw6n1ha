class Solution {
    public List<Integer> partitionLabels(String s) {
        
        List<Integer> list = new ArrayList<>();
        int[] lastIndex = new int[26];


        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            lastIndex[c - 'a'] = i;

        }

        int last = 0, start = 0;
        for(int i = 0;i < s.length(); i++){
            char c = s.charAt(i);
            last = Math.max(last, lastIndex[c - 'a']);
            if(last == i){
                int len = last - start + 1;
                list.add(len);
                start = last + 1;
            }
        }
        return list;
    }
}
