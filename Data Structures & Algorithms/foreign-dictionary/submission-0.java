
class Solution {
    public String foreignDictionary(String[] words) {
        // Step 1: Create adjacency list and indegree map
        Map<Character, List<Character>> adj = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        
        // Initialize for all characters
        for (String word : words) {
            for (char c : word.toCharArray()) {
                adj.putIfAbsent(c, new ArrayList<>());
                indegree.putIfAbsent(c, 0);
            }
        }
        
        // Step 2: Build the graph by comparing adjacent words
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            
            // Check for invalid case: word2 is prefix of word1
            // If word1 is longer and starts with word2, it's invalid
            // Example: ["abc", "ab"] -> invalid
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }
            
            // Find first different character
            int minLen = Math.min(word1.length(), word2.length());
            for (int j = 0; j < minLen; j++) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);
                
                if (c1 != c2) {
                    // Add edge c1 -> c2 (c1 comes before c2)
                    adj.get(c1).add(c2);
                    break; // Only first difference matters
                }
            }
        }
        
        // Step 3: Calculate indegree for each node
        for (char node : adj.keySet()) {
            for (char neighbor : adj.get(node)) {
                indegree.put(neighbor, indegree.get(neighbor) + 1);
            }
        }
        
        // Step 4: Topological sort using BFS (Kahn's algorithm)
        Queue<Character> queue = new LinkedList<>();
        StringBuilder order = new StringBuilder();
        
        // Add nodes with 0 indegree to queue
        for (char node : indegree.keySet()) {
            if (indegree.get(node) == 0) {
                queue.offer(node);
            }
        }
        
        while (!queue.isEmpty()) {
            char curr = queue.poll();
            order.append(curr);
            
            for (char neighbor : adj.get(curr)) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        // Step 5: Check if we processed all nodes (no cycle)
        return order.length() == adj.size() ? order.toString() : "";
    }
}