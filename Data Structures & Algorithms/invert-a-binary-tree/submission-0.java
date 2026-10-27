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
    public TreeNode invertTree(TreeNode root) {
        // swap left and right trees
        // three ways to do this: iterative dfs, recursive dfs, bfs
        // we could do this with a stack using iterative dfs
        // but recursive df codebase is more simple to read

        if (root == null) return null;

        // need a temp node to store one of the swapped ones
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // dfs: go to children
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
