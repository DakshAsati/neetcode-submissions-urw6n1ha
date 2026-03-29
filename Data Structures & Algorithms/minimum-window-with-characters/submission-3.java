class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int need = t.length();
        int[] ans = {0, Integer.MAX_VALUE};
        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);

            if (map.containsKey(c) && map.get(c) > 0) {
                need--;
            }

            map.put(c, map.getOrDefault(c, 0) - 1);

            if (need == 0) {
                while (true) {
                    char lc = s.charAt(l);
                    if (map.containsKey(lc) && map.get(lc) == 0) break;
                    map.put(lc, map.getOrDefault(lc, 0) + 1);
                    l++;
                }

                if (r - l < ans[1] - ans[0]) {
                    ans[0] = l;
                    ans[1] = r;
                }

                map.put(s.charAt(l), map.get(s.charAt(l)) + 1);
                need++;
                l++;
            }
        }

        return ans[1] >= s.length() ? "" : s.substring(ans[0], ans[1] + 1);
    }
}
