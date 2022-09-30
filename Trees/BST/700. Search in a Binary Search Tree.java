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
 
// recursive
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        return val < root.val? searchBST(root.left, val) : searchBST(root.right, val);
    }
}

// iterative
class Solution2 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return root;
        }
        while (root != null) {
            if (root.val == val) {
                return root;
            }
            else if (root.val < val) {
                root = root.right;
            }
            else {
                root = root.left;
            }
        }
        return root;
    }
}
