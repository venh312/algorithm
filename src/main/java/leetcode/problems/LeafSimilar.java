package leetcode.problems;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class LeafSimilar {
  public boolean leafSimilar(TreeNode root1, TreeNode root2) {
      List<Integer> list = new ArrayList<>();
      List<Integer> list2 = new ArrayList<>();
  
      searchLeftNode(root1, list);
      searchLeftNode(root2, list2);
  
      return list.equals(list2) ;
  }
  
  
  public void searchLeftNode(TreeNode node, List<Integer> list) {
      if (node == null) return;
      if (node.left == null && node.right == null) {
          list.add(node.val);
      }
      searchLeftNode(node.left, list);
      searchLeftNode(node.right, list);
  }
}
