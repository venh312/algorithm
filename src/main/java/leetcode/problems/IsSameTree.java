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

Given the roots of two binary trees p and q, write a function to check if they are the same or not.
Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

Example 1:
Input: p = [1,2,3], q = [1,2,3]
Output: true

Example 2:
Input: p = [1,2], q = [1,null,2]
Output: false

Example 3:
Input: p = [1,2,1], q = [1,1,2]
Output: false
*/
public class IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 두 트리가 모두 null이면 같은 것으로 간주
        if (p == null && q == null) {
            return true;
        }
        // 두 트리 중 하나만 null이면 다른 것으로 간주
        if (p == null || q == null) {
            return false;
        }
        // 현재 노드의 값이 다르면 다른 것으로 간주
        if (p.val != q.val) {
            return false;
        }
        // 왼쪽 서브트리와 오른쪽 서브트리의 동일성을 재귀적으로 확인
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
  
}
