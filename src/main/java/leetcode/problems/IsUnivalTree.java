/*
A binary tree is uni-valued if every node in the tree has the same value.
Given the root of a binary tree, return true if the given tree is uni-valued, or false otherwise.

Example 1:
Input: root = [1,1,1,1,1,null,1]
Output: true

Input: root = [2,2,2,5,2]
Output: false
*/
class IsUnivalTree {
      private boolean find = true;
      public boolean isUnivalTree(TreeNode root) {
          inOrder(root, root.val);
          return find;
      }

      public void inOrder(TreeNode root, int val) {
          if (root == null) return;
          inOrder(root.left, root.val);
          if (root.val != val) {
              find = false;
              return;
          }
          inOrder(root.right, root.val);
      }
}
