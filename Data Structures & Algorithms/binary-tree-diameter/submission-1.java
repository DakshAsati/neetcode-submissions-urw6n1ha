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

    private int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {

        height(root);
        return diameter;

        
    }

    private int height(TreeNode node){
        if(node == null) return 0;

        int right = height(node.right);
        int left = height(node.left);

        diameter = Math.max(diameter, right + left);

        return Math.max(left, right) + 1;
    }
}
/* assign left and right TreeNode in tree and apply dfs for this and 
return max value out of all*/
