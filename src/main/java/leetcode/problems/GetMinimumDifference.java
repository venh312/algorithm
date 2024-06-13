package leetcode.problems;

/**
Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.

Example 1:
Input: root = [4,2,6,1,3]
Output: 1

Example 2:
Input: root = [1,0,48,null,null,12,49]
Output: 1
 */
class GetMinimumDifference {
    // Runtime: 4 ms, faster than 13.81%
    public int getMinimumDifference(TreeNode root) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        searchMinimum(root, q);

        int result = Integer.MAX_VALUE;
        int prev = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            int cur = q.poll();
            result = Math.min(result, Math.abs(prev - cur));
            prev = cur;
        }

        return result;
    }

    public void searchMinimum(TreeNode root, PriorityQueue<Integer> q) {
        if (root == null) return;
        q.add(root.val);
        searchMinimum(root.left, q);
        searchMinimum(root.right, q);
    }
}
