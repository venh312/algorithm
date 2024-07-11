package leetcode.problems;

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
class MinDiffInBST {
    private Integer previous;
    private int minDifference;
    
    // Runtime: 0 ms, faster than 100.00%
    public int minDiffInBST(TreeNode root) {
        previous = null;
        minDifference = Integer.MAX_VALUE;
        inorderTraversal(root);
        return minDifference;
    }

    private void inorderTraversal(TreeNode node) {
        if (node == null) return;

        // Traverse left subtree
        inorderTraversal(node.left);

        // Process current node
        if (previous != null) {
            minDifference = Math.min(minDifference, node.val - previous);
        }
        previous = node.val;

        // Traverse right subtree
        inorderTraversal(node.right);
    }
}
