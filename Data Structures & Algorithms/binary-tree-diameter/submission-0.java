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
    public int diameterOfBinaryTree(TreeNode root) {
        // we need a way to store the max path length
        // we can use an arr so it isn't changed with recursion
        int[] res = new int[1];
        dbt(root, res);
        return res[0];
    }

    private int dbt(TreeNode root, int[] res) {
        if (root == null) return 0;
        // traverse left, then right
        int left = dbt(root.left, res);
        int right = dbt(root.right, res);
        // find max
        res[0] = Math.max(res[0], left + right);
        return 1 + Math.max(left, right);

    }
}
