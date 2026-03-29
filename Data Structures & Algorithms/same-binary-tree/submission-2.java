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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<String> tree1 = new ArrayList<>();
        List<String> tree2 = new ArrayList<>();

        serialize(p, tree1);
        serialize(q, tree2);

        return tree1.equals(tree2);


    
        
    }

    private void serialize(TreeNode node, List<String> list){
        if(node == null){
            list.add("null");
            return;
        }

        list.add(String.valueOf(node.val));
        serialize(node.left, list);
        serialize(node.right, list);

    }
}
