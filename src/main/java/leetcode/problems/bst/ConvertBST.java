/*
https://leetcode.com/problems/convert-bst-to-greater-tree/description/

Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus the sum of all keys greater than the original key in BST.
As a reminder, a binary search tree is a tree that satisfies these constraints:
 - The left subtree of a node contains only nodes with keys less than the node's key.
 - The right subtree of a node contains only nodes with keys greater than the node's key.
 - Both the left and right subtrees must also be binary search trees

이진 검색 트리(BST)의 루트가 주어지면, 원래 BST의 모든 키가 원래 키에 원래 키보다 큰 모든 키의 합을 더한 값으로 변경되도록 그레이터 트리로 변환합니다.
다시 한 번 말씀드리자면, 이진 검색 트리는 다음과 같은 제약 조건을 충족하는 트리입니다:
  - 노드의 왼쪽 하위 트리에는 키가 노드의 키보다 작은 노드만 포함됩니다.
  - 노드의 오른쪽 하위 트리에는 키가 노드의 키보다 큰 노드만 포함됩니다.
  - 왼쪽과 오른쪽 하위 트리 모두 이진 검색 트리여야 합니다.

Input: root = [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
Output: [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
 */
 class ConvertBST {
    private int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;

        // 오른쪽부터 방문 (큰 값 순으로 누적)
        convertBST(root.right);

        // 현재 노드 값 갱신
        sum += root.val;
        root.val = sum;

        // 왼쪽 방문 (작은 값 갱신)
        convertBST(root.left);

        return root;
    }
}
