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

public class Codec {

    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();


        if(root == null){
            return res.toString();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();


            if(curr == null){
                res.append("null ");
                continue;
            }
            res.append(curr.val).append(" ");

            queue.add(curr.left);
            queue.add(curr.right);
        }

        return res.toString();
        
    }

    public TreeNode deserialize(String data) {
        if(data.isEmpty()) return null;

        String[] str = data.split(" ");
        int len = str.length;

        TreeNode root = new TreeNode(Integer.valueOf(str[0]));
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);

        for(int i = 1; i < len; i++){
            TreeNode parent = queue.poll();

            if(!str[i].equals("null")){
                parent.left = new TreeNode(Integer.valueOf(str[i]));
                queue.add(parent.left);
            }
            i++;

            if(i < len && !str[i].equals("null")){
                parent.right = new TreeNode(Integer.parseInt(str[i]));
                queue.add(parent.right);
            }
        }

        return root;

        
    }
}
