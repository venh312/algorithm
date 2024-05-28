package leetcode.problems;

/*
Given the root of a binary tree, return the sum of all left leaves.
A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: 24
Explanation: There are two left leaves in the binary tree, with values 9 and 15 respectively.

Example 2:
Input: root = [1]
Output: 0
*/
class SumOfLeftLeaves {
    // Runtime: 0 ms, faster than 100.00%
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return sumOfLeftLeavesHelper(root, false);
    }

    private int sumOfLeftLeavesHelper(TreeNode node, boolean isLeft) {
        if (node == null) {
            return 0;
        }

        // 현재 노드가 잎 노드이고, 왼쪽 자식 노드일 경우
        if (node.left == null && node.right == null && isLeft) {
            return node.val;
        }

        // 재귀적으로 왼쪽과 오른쪽 서브트리를 탐색
        return sumOfLeftLeavesHelper(node.left, true) + sumOfLeftLeavesHelper(node.right, false);
    }

}
