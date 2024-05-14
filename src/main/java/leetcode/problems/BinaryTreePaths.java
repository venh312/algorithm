/*
Given the root of a binary tree, return all root-to-leaf paths in any order.
A leaf is a node with no children.

Example 1:
Input: root = [1,2,3,null,5]
Output: ["1->2->5","1->3"]

Example 2:
Input: root = [1]
Output: ["1"]
*/
public List<String> binaryTreePaths(TreeNode root) {
    List<String> list = new ArrayList<>();
    if (root != null) {
        String str = String.valueOf(root.val);

        if (root.left == null && root.right == null)
            list.add(str);

        dfs(root.left, list, str);
        dfs(root.right, list, str);
    }

    return list;
}

private void dfs(TreeNode node, List<String> list, String str) {
    if (node == null) return;

    str += "->" + String.valueOf(node.val);

    if (node.left == null && node.right == null)
        list.add(str);

    dfs(node.left, list, str);
    dfs(node.right, list, str);
}
