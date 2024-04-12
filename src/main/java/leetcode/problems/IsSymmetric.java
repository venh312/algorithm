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
 
Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

Example 1:
Input: root = [1,2,2,3,4,4,3]
Output: true

Example 2:
Input: root = [1,2,2,null,3,null,3]
Output: false
*/
class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        // 주어진 트리가 null이면 대칭이므로 true를 반환
        if (root == null) {
            return true;
        }

        // 대칭성을 확인하는 helper 함수 호출
        return isMirror(root.left, root.right);
    }
    
    private boolean isMirror(TreeNode left, TreeNode right) {
        // 두 노드가 모두 null인 경우 대칭
        if (left == null && right == null) {
            return true;
        }
        // 두 노드 중 하나만 null이면 대칭이 아님
        if (left == null || right == null) {
            return false;
        }
        // 현재 노드의 값이 다르면 대칭이 아님
        if (left.val != right.val) {
            return false;
        }
      
        // 왼쪽 서브트리의 왼쪽 노드와 오른쪽 서브트리의 오른쪽 노드를 비교
        // 왼쪽 서브트리의 오른쪽 노드와 오른쪽 서브트리의 왼쪽 노드를 비교
        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }
}
