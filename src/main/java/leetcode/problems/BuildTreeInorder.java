/*
https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree
and postorder is the postorder  traversalof the same tree, construct and return the binary tree.

Example 1:
Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
Output: [3,9,20,null,null,15,7]

Example 2:
Input: inorder = [-1], postorder = [-1]
Output: [-1]
 */
class BuildTreeInorder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // 인덱스를 배열의 끝에서 시작하도록 설정
        int[] postIndex = {postorder.length - 1};

        // 중위 순회에서 각 값의 인덱스를 빠르게 찾기 위한 맵
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        // 재귀적으로 트리를 구성하는 함수
        return build(postorder, 0, inorder.length - 1, postIndex, inorderMap);
    }

    // 재귀적으로 트리를 구축하는 함수
    private TreeNode build(int[] postorder, int inStart, int inEnd,
                           int[] postIndex, Map<Integer, Integer> inorderMap) {
        // 종료 조건: start가 end보다 크면 null 반환
        if (inStart > inEnd) return null;

        // 후위 순회의 현재 마지막 값이 루트 값
        int rootVal = postorder[postIndex[0]--];
        TreeNode root = new TreeNode(rootVal);

        // 루트의 인덱스를 중위 순회 배열에서 찾기
        int rootIndex = inorderMap.get(rootVal);

        // 오른쪽 서브트리부터 먼저 처리
        root.right = build(postorder, rootIndex + 1, inEnd, postIndex, inorderMap);
        root.left = build(postorder, inStart, rootIndex - 1, postIndex, inorderMap);

        return root;
    }
}
