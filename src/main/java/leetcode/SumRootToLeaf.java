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
class SumRootToLeaf {
    private List<String> list = new ArrayList<>();
    public int sumRootToLeaf(TreeNode root) {
        dfs(root, "");
        return list.stream()
                     .mapToInt(s -> Integer.parseInt(s, 2))
                     .sum();
    }
    
    public void dfs(TreeNode root, String sb) {
        if (root == null) return;
        sb += String.valueOf(root.val);
        if (root.left == null && root.right == null) {
            list.add(sb);
        }
        dfs(root.left, sb);
        dfs(root.right, sb);
    }
}
