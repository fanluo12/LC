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
    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sum = Integer.MIN_VALUE;
        int level = 1;
        int curLevel = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int tmpSum  = 0;
            for (int i = 0; i < size; i ++) {
                TreeNode node = queue.poll();
                tmpSum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            if (tmpSum > sum) {
                sum = tmpSum;
                level = curLevel;
            }
            curLevel ++;
        }
        return level;
    }
}
