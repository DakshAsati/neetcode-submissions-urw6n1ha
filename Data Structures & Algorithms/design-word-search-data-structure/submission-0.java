class WordDictionary {

    class TrieNode {
        boolean endOfWord;
        TrieNode[] next = new TrieNode[26];
    }

    TrieNode root = null;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.next[c - 'a'] == null) {
                node.next[c - 'a'] = new TrieNode();
            }
            node = node.next[c - 'a'];
        }
        node.endOfWord = true;
    }

    public boolean search(String word) {
        char[] c = word.toCharArray();
        return helper(root, 0, c);
    }

    boolean helper(TrieNode node, int pos, char[] ch) {
        for (int i = pos; i < ch.length; i++) {
            if (ch[i] == '.') {
                for (int p = 0; p < 26; p++) {
                    if (node.next[p] != null) {
                        if (helper(node.next[p], i + 1, ch)) {
                            return true;
                        }
                    }
                }
                return false;
            } else {
                if (node.next[ch[i] - 'a'] != null) {
                    node = node.next[ch[i] - 'a'];
                } else {
                    return false;
                }
            }
        }
        return node.endOfWord;
    }
}
