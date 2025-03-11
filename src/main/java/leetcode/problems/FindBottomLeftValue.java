/*
https://leetcode.com/problems/find-bottom-left-tree-value/description/

Given the root of a binary tree, return the leftmost value in the last row of the tree.

Example 1:

Input: root = [2,1,3]
Output: 1
*/
class FindBottomLeftValue {
    private int resultDepth = 0;
    private int resultValue = 0;
    public int findBottomLeftValue(TreeNode root) {
        if (root != null) {
            resultValue = root.val;
        }
        
        findBottomLeftValue(root, 0);
        return resultValue;
    }
    
    private void findBottomLeftValue(TreeNode node, int depth) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            if (depth > resultDepth) {
                resultDepth = depth;
                resultValue = node.val;
            }
            
            return;
        }

        findBottomLeftValue(node.left, depth + 1);
        findBottomLeftValue(node.right, depth + 1);

        return;
    }

    public int findBottomLeftValueGPT(TreeNode root) {
        if (root == null) return -1;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        int leftmostValue = root.val; // 최하단 왼쪽 값 저장

        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                
                // 첫 번째 노드가 가장 왼쪽 값
                if (i == 0) {
                    leftmostValue = current.val;
                }

                // BFS: 왼쪽 -> 오른쪽 순으로 탐색
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
        }

        return leftmostValue;
    }

}
