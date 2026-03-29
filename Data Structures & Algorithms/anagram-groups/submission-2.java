class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String,List<String>> ans = new HashMap<>();

        for(String str : strs){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String st = new String(ch);
            if(!ans.containsKey(st)){
                ans.put(st, new ArrayList<>());
            }
            ans.get(st).add(str);

        }
        return new ArrayList<>(ans.values());
        
    }
}
