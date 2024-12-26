/*
https://leetcode.com/problems/recover-binary-search-tree/

You are given the root of a binary search tree (BST),
where the values of exactly two nodes of the tree were swapped by mistake.
Recover the tree without changing its structure.

Example 1:
Input: root = [1,3,null,null,2]
Output: [3,1,null,null,2]
Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 makes the BST valid.

Example 2:
Input: root = [3,1,4,null,null,2]
Output: [2,1,4,null,null,3]
Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2 and 3 makes the BST valid.
*/
class RecoverTree {
    private TreeNode first = null; // 첫 번째 잘못된 노드
    private TreeNode second = null; // 두 번째 잘못된 노드
    private TreeNode prev = new TreeNode(Integer.MIN_VALUE); // 이전 노드 (초기값은 최소값)

    public void recoverTree(TreeNode root) {
        // 중위 순회를 통해 잘못된 노드 찾기
        inorderTraversal(root);

        // 잘못된 두 노드의 값을 교환
        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }

    private void inorderTraversal(TreeNode root) {
        if (root == null) return;

        // 왼쪽 서브트리 탐색
        inorderTraversal(root.left);

        // 현재 노드가 이전 노드보다 작아야 하는 BST 속성 위반 탐지
        if (prev.val > root.val) {
            if (first == null) {
                first = prev; // 첫 번째 잘못된 노드
            }
            second = root; // 두 번째 잘못된 노드
        }
        prev = root; // 이전 노드를 현재 노드로 업데이트

        // 오른쪽 서브트리 탐색
        inorderTraversal(root.right);
    }
}
