/*
114. Flatten Binary Tree to Linked List
https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

Given the root of a binary tree, flatten the tree into a "linked list":

The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
The "linked list" should be in the same order as a pre-order traversal of the binary tree.

Example 1:
Input: root = [1,2,5,3,4,null,6]
Output: [1,null,2,null,3,null,4,null,5,null,6]

Example 2:
Input: root = []
Output: []

Example 3:
Input: root = [0]
Output: [0]
*/
class Flatten {
    TreeNode attachNode = null;
    TreeNode leftLastNode = null;

    public void flatten(TreeNode root) {
        if (root == null) return;
        makeRightNode(root.left, "left");
        attachNode = null;
        makeRightNode(root.right, "right");
        leftLastNode.right = root.right;
        root.right = root.left;
        root.left = null;
    }

    void makeRightNode(TreeNode root, String direction) {
        if (root == null) return;
        makeRightNode(root.right, direction);
        makeRightNode(root.left, direction);
        if (attachNode == null) {
            if (direction.equals("left")) leftLastNode = root;
            attachNode = root;
        } else {
            root.right = attachNode;
            root.left = null;
            attachNode = root;
        }
    }
    
    // GPT 풀이
    public void flattenGPT(TreeNode root) {
        if (root == null) return;

        // 왼쪽과 오른쪽 서브트리를 재귀적으로 평탄화
        flattenGPT(root.left);
        flattenGPT(root.right);

        // 왼쪽 서브트리를 오른쪽으로 이동
        TreeNode tempRight = root.right; // 기존의 오른쪽 서브트리를 저장
        root.right = root.left; // 왼쪽 서브트리를 오른쪽으로 이동
        root.left = null; // 왼쪽 서브트리는 null로 설정

        // 새로운 오른쪽 서브트리의 끝으로 이동
        TreeNode current = root.right;
        while (current != null && current.right != null) {
            current = current.right;
        }

        // 기존의 오른쪽 서브트리를 이어붙임
        if (current != null) {
            current.right = tempRight;
        } else {
            root.right = tempRight; // 왼쪽 서브트리가 없던 경우 처리
        }
    }
}
