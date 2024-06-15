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
class FindTilt {
    int result = 0;
    // Runtime: 0 ms, faster than 100.00%
    public int findTilt(TreeNode root) {
        if (root == null) return 0;
        restructTilt(root);
        return result;
    }
    
    public int restructTilt(TreeNode root) {
        if (root == null) return 0;
        
        int leftSum = restructTilt(root.left);
        int rightSum = restructTilt(root.right);  
        result += Math.abs(leftSum - rightSum);
        
        return root.val + leftSum + rightSum;
    }
}


