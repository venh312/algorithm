/**
https://leetcode.com/problems/kth-smallest-element-in-a-bst/submissions/1508919625/

Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

Input: root = [3,1,4,null,2], k = 1
Output: 1
 */
class KthSmallest {
    private int result = 0;
    private int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }

    void inorder(TreeNode root, int k) {
        if (root == null) return;
        
        inorder(root.left, k);

        count++;
        if (count == k) {
            result = root.val;
            return;
        }
        
        inorder(root.right, k);
    }
}
