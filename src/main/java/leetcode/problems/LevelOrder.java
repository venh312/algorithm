/**
https://leetcode.com/problems/binary-tree-level-order-traversal/submissions/
Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]

Example 2:
Input: root = [1]
Output: [[1]]

Example 3:
Input: root = []
Output: []
 */
class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        } else {
            Map<Integer, List<Integer>> values = new HashMap<>();
            dfs(values, new HashSet<>(), root, 0);
            result.addAll(values.values());
            return result;
        }
    }
    private void dfs(Map<Integer, List<Integer>> values, HashSet<TreeNode> visited, TreeNode root, int depth) {
        List<Integer> value = values.getOrDefault(depth, new ArrayList<>());
        visited.add(root);
        values.put(depth, value);
        value.add(root.val);

        if (root.left == null && root.right == null) {
            return;
        }

        if (root.left != null && !visited.contains(root.left)) {
            dfs(values, visited, root.left, depth+1);
        }
        if (root.right != null && !visited.contains(root.right)) {
            dfs(values, visited, root.right, depth+1);
        }
    }

    // BFS 풀이
    public List<List<Integer>> bfs(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;  // 트리가 비어 있다면 빈 리스트 반환
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);  // 루트 노드를 큐에 삽입

        while (!queue.isEmpty()) {
            int levelSize = queue.size();  // 현재 레벨의 노드 수
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();  // 큐에서 노드를 꺼냄
                currentLevel.add(node.val);  // 현재 노드 값 추가

                // 자식 노드가 있으면 큐에 삽입
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            result.add(currentLevel);  // 현재 레벨의 노드를 결과에 추가
        }

        return result;
    }
}
