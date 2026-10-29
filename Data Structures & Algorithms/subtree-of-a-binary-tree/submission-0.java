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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // check: subtree of root with same structure and node vals of subroot E
        if (subRoot == null) return true; // empty subroot -> always T

        if (root == null) return false; // root empty but subroot not -> always F

        if (matches(root, subRoot)) return true;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);

    }

    public boolean matches(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;

        if (root == null || subRoot == null || root.val != subRoot.val) return false;

        return matches(root.left, subRoot.left) && matches(root.right, subRoot.right);
    }
}
