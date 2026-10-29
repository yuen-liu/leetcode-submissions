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
    public List<Integer> rightSideView(TreeNode root) {
        // use bfs here since the rightmost node is just node added last to the queue/level
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode right = null;
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                right = node;

                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }

            if (right != null) res.add(right.val);
        }

        return res;

    }
}
