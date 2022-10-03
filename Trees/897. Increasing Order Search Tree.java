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
    
    private TreeNode pre;
    private TreeNode cur;
    
    public TreeNode increasingBST(TreeNode root) {
        inOrder(root);
        return cur;
    }
    
    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        if (cur == null) {
            cur = root;
        }
        else {
            pre.right = root;
        }
        pre = root;
        root.left = null;
        inOrder(root.right);
    }
}
