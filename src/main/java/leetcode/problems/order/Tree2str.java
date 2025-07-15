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
https://leetcode.com/problems/construct-string-from-binary-tree/
 */
class Tree2str {
    public String tree2str(TreeNode root) {
        StringBuilder result = new StringBuilder();
        if (root == null) return result.toString();
        result.append(root.val);
        if (root.left == null && root.right != null) result.append("()");
        preOrder(root.left, result);
        preOrder(root.right, result);
        return result.toString();
    }

    public void preOrder(TreeNode treeNode, StringBuilder result) {
        if (treeNode == null) return;
        result.append("(");
        result.append(treeNode.val);
        if (treeNode.left == null && treeNode.right != null) result.append("()");
        preOrder(treeNode.left, result);
        preOrder(treeNode.right, result);
        result.append(")");
    }
}
