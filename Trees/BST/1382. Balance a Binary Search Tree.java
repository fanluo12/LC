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
    public TreeNode balanceBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        
        List<Integer> bstArr = new ArrayList<>();
        inOrder(root, bstArr);
        
        root = createBST(bstArr, 0, bstArr.size() - 1);
        return root;
        
    }
    
    public void inOrder(TreeNode root, List<Integer> bstArr) {
        if (root == null) {
            return;
        }
        inOrder(root.left, bstArr);
        bstArr.add(root.val);
        inOrder(root.right, bstArr);
    }
    
    public TreeNode createBST(List<Integer> bstArr, int start, int end) {
        if (start > end) {
            return null;
        }
        
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(bstArr.get(mid));
        root.left = createBST(bstArr, start, mid - 1);
        root.right = createBST(bstArr, mid + 1, end);
        return root;
    }
}
