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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    HashMap<Integer, Integer> inOrderIndexMap = new HashMap<>();
    for(int i = 0; i < inorder.length; i++){
        inOrderIndexMap.put(inorder[i], i);
    }
        

        return splitTree(preorder, inOrderIndexMap, 0,0,inorder.length - 1);
    }

    private TreeNode splitTree(int[] preOrder, Map<Integer,Integer>inOrderIndexMap, int rootIndex, int left, int right){

        if(left > right || rootIndex >= preOrder.length) return null;


        TreeNode root = new TreeNode(preOrder[rootIndex]);
        int mid = inOrderIndexMap.get(preOrder[rootIndex]);


        int leftSize = mid - left;

        root.left = splitTree(preOrder, inOrderIndexMap, rootIndex + 1, left, mid - 1);

        root.right = splitTree(preOrder, inOrderIndexMap, rootIndex + 1 + leftSize, mid + 1 , right);


        return root;
    }
}
