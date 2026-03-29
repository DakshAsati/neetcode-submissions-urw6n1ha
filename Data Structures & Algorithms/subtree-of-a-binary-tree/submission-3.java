/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    HashSet<String> set = new HashSet<>();
    boolean found = false;

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        String subHash = buildHash(subRoot);
        dfs(root, subHash);
        return found;
    }

    private String dfs(TreeNode node, String subHash) {
        if (node == null) return "#";

        String left = dfs(node.left, subHash);
        String right = dfs(node.right, subHash);

        String current = node.val + "," + left + "," + right;

        if (current.equals(subHash)) {
            found = true;
        }

        return current;
    }

    private String buildHash(TreeNode node) {
        if (node == null) return "#";
        return node.val + "," +
               buildHash(node.left) + "," +
               buildHash(node.right);
    }
}