/*
https://leetcode.com/problems/unique-binary-search-trees-ii/
Given an integer n, return all the structurally unique BST's (binary search trees), which has exactly n nodes of unique values from 1 to n.
Return the answer in any order.

Example 1:
Input: n = 3
Output: [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
 */
public class UniqueBST {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return buildTrees(1, n);
    }

    private List<TreeNode> buildTrees(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        
        // Base case: if start > end, return a list with null (empty tree)
        if (start > end) {
            result.add(null);
            return result;
        }

        // Iterate through all possible root values
        for (int i = start; i <= end; i++) {
            // Recursively generate all left and right subtrees
            List<TreeNode> leftTrees = buildTrees(start, i - 1);
            List<TreeNode> rightTrees = buildTrees(i + 1, end);

            // Combine each left and right subtree with the current root
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }

        return result;
    }
}
