package leetcode.problems;
/*
Given the root of a binary tree, return the length of the diameter of the tree.
The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
The length of a path between two nodes is represented by the number of edges between them.

Example 1:
Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].

Example 2:
Input: root = [1,2]
Output: 1
*/
class DiameterOfBinaryTree {
    int diameter = 0;
    // Runtime: 0 ms, faster than 100.00%
    public int diameterOfBinaryTree(TreeNode root) {
        calculateDepth(root);
        return diameter;
    }

    private int calculateDepth(TreeNode node) {
        if (node == null) return 0;

        int leftDepth = calculateDepth(node.left);
        int rightDepth = calculateDepth(node.right);

        // 현재 노드를 포함한 경로의 최대 길이
        diameter = Math.max(diameter, leftDepth + rightDepth);

        // 현재 노드의 하위 트리의 최대 깊이
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
