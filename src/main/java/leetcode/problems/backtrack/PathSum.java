/*
https://leetcode.com/problems/path-sum-ii/description/

Given the root of a binary tree and an integer targetSum,
return all root-to-leaf paths where the sum of the node values in the path equals targetSum.
Each path should be returned as a list of the node values, not node references.

A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.

Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: [[5,4,11,2],[5,8,4,5]]
Explanation: There are two paths whose sum equals targetSum:
5 + 4 + 11 + 2 = 22
5 + 8 + 4 + 5 = 22
 */
class PathSum {
  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
      List<List<Integer>> result = new ArrayList<>();
      dfs(root, targetSum, new ArrayList<>(), result);
      return result;
  }
  
  private void dfs(TreeNode node, int targetSum, List<Integer> path, List<List<Integer>> result) {
      if (node == null) return;
  
      // 현재 노드 값을 경로에 추가
      path.add(node.val);
      // 목표값에서 현재값 제거
      targetSum -= node.val;
  
      // 리프 노드이고 목표값이 0이라면
      if (node.left == null && node.right == null && targetSum == 0) {
          result.add(new ArrayList<>(path));
      } else {
          // 좌우 서브트리 탐색
          dfs(node.left, targetSum, path, result);
          dfs(node.right, targetSum, path, result);
      }
  
      // 현재 노드를 경로에서 제거 (백트래킹)
      path.remove(path.size() - 1);
  }
}
