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
 * 
 https://leetcode.com/problems/trim-a-binary-search-tree/
 */
class TrimBST {
    public TreeNode trimBST(TreeNode root, int low, int high) {
         if (root == null) {
            return null;
        }

        // 현재 노드의 값이 low보다 작다면, 왼쪽 서브트리는 전부 잘림
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }

        // 현재 노드의 값이 high보다 크다면, 오른쪽 서브트리는 전부 잘림
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }

        // 현재 노드의 값이 범위 내에 있으면, 양쪽 서브트리를 재귀적으로 자름
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        return root;
    }
}
