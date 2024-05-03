/**
Given the root of a complete binary tree, return the number of the nodes in the tree.
According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
Design an algorithm that runs in less than O(n) time complexity.

Example 1:
Input: root = [1,2,3,4,5,6]
Output: 6

Example 2:
Input: root = []
Output: 0

Example 3:
Input: root = [1]
Output: 1
*/
public class CountNodes {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        
        int leftHeight = leftHeight(root);
        int rightHeight = rightHeight(root);
        
        // 만약 루트의 왼쪽 서브트리와 오른쪽 서브트리의 높이가 같다면,
        // 루트의 오른쪽 서브트리는 완전 이진 트리가 아니므로
        // 왼쪽 서브트리만 계산하여 노드 수를 반환합니다.
        if (leftHeight == rightHeight) {
            return (1 << leftHeight) - 1;
        } else {
            // 왼쪽 서브트리의 높이와 오른쪽 서브트리의 높이가 다르다면,
            // 왼쪽 서브트리는 완전 이진 트리이므로 오른쪽 서브트리도 완전 이진 트리여야 합니다.
            // 따라서 오른쪽 서브트리의 노드 수를 재귀적으로 계산하여 반환합니다.
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }
    
    // 왼쪽 서브트리의 높이를 계산합니다.
    private int leftHeight(TreeNode root) {
        int height = 0;
        while (root != null) {
            root = root.left;
            height++;
        }
        return height;
    }
    
    // 오른쪽 서브트리의 높이를 계산합니다.
    private int rightHeight(TreeNode root) {
        int height = 0;
        while (root != null) {
            root = root.right;
            height++;
        }
        return height;
    }
}
