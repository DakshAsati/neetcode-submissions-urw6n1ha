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

    private int maxsum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {

            helper(root);
            return maxsum;


        
    }

    private int helper(TreeNode node){
        if(node == null) return 0;

        int leftgain = Math.max(helper(node.left), 0);
        int rightgain = Math.max(helper(node.right), 0);

        int total = leftgain + rightgain + node.val;


        maxsum = Math.max(maxsum, total);

        return node.val + Math.max(leftgain, rightgain);


    }
}
