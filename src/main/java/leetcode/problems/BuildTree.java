/*
https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
105. Construct Binary Tree from Preorder and Inorder Traversal

Given two integer arrays preorder and inorder
where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree,
construct and return the binary tree.

두 개의 정수 배열이 이진 트리의 preorder 및 inorder 경우, 동일한 트리의 inorder 순회가 주어지면
이진 트리를 구성하고 반환합니다.

Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]

Input: preorder = [-1], inorder = [-1]
Output: [-1]
 */
class BuildTree {
    int preorderIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // inorder 배열의 값을 빠르게 찾기 위한 HashMap
        HashMap<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return buildTreeHelper(preorder, inorderMap, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] preorder, HashMap<Integer, Integer> inorderMap, int left, int right) {
        // base case: left가 right보다 크면 null을 반환
        if (left > right) {
            return null;
        }

        // preorder에서 현재 루트 값 추출
        int rootValue = preorder[preorderIndex++]; // 3

        // 루트 노드를 생성
        TreeNode root = new TreeNode(rootValue);

        // inorder 배열에서 루트의 위치를 찾음
        int rootIndex = inorderMap.get(rootValue);

        // 왼쪽 서브트리 구성
        root.left = buildTreeHelper(preorder, inorderMap, left, rootIndex - 1);

        // 오른쪽 서브트리 구성
        root.right = buildTreeHelper(preorder, inorderMap, rootIndex + 1, right);

        return root;
    }
}
