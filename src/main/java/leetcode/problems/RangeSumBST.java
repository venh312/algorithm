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
class RangeSumBST {
    private int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        inOrder(root, low, high);
        return sum;
    }
    
    public void inOrder(TreeNode root, int low, int high) {
        if (root == null) return;
        inOrder(root.left, low, high);
        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }
        inOrder(root.right, low, high);
    }
}
