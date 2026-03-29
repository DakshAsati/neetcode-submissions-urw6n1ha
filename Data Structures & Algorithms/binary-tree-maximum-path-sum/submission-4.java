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

    public int maxPathSum(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE;

        int leftMax = maxPathSum(root.left);
        int rightMax = maxPathSum(root.right);

        int throughRoot =
                root.val
                + Math.max(0, maxDownward(root.left))
                + Math.max(0, maxDownward(root.right));

        return Math.max(throughRoot, Math.max(leftMax, rightMax));
    }

    private int maxDownward(TreeNode node) {
        if (node == null) return 0;

        int left = maxDownward(node.left);
        int right = maxDownward(node.right);

        return node.val + Math.max(0, Math.max(left, right));
    }
}