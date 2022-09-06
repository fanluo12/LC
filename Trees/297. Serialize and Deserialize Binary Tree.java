/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
		StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                sb.append(node.val + ",");
            }
            else {
                sb.append("Null,");
            }
                
            if (node != null) {
                queue.offer(node.left);
                queue.offer(node.right);
             } 
        }
       return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "") {
            return null;
        }
        String[] tokens = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(tokens[0]));
        queue.offer(root);
        
        int index = 1;

        while(!queue.isEmpty() && index < tokens.length) {
            TreeNode parent = queue.poll();
            if (!tokens[index].equals("Null")) {
                TreeNode left = new TreeNode(Integer.parseInt(tokens[index]));
                parent.left = left;
                queue.offer(left);
            }
            index ++;
            
            if (!tokens[index].equals("Null")) {
                TreeNode right = new TreeNode(Integer.parseInt(tokens[index]));
                parent.right = right;
                queue.offer(right);
            }
            index ++;
        }
        
        return root;
    }

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
