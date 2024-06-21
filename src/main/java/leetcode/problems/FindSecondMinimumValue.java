package leetcode.problems;

/*
Given a non-empty special binary tree consisting of nodes with the non-negative value,
where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes,
then this node's value is the smaller value among its two sub-nodes. More formally,
the property root.val = min(root.left.val, root.right.val) always holds.

Given such a binary tree, you need to output the second minimum value
in the set made of all the nodes' value in the whole tree.

If no such second minimum value exists, output -1 instead.

Input: root = [2,2,5,null,null,5,7]
Output: 5
Explanation: The smallest value is 2, the second smallest value is 5.
*/
public class FindSecondMinimumValue {
    
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        Collections.sort(list);
        return list.size() < 2 ? -1 : list.get(1);
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        if (!list.contains(root.val)) list.add(root.val);
        inorder(root.left, list);
        inorder(root.right, list);
    }

    public int findSecondMinimumValue2(TreeNode root) {
        if (root == null) return -1;
        int min = root.val; // 최소값
        int[] result = {Integer.MAX_VALUE}; // 두 번째로 작은 값을 저장할 배열

        dfs(root, min, result);

        return result[0] == Integer.MAX_VALUE ? -1 : result[0];
    }

    private void dfs(TreeNode node, int min, int[] result) {
        if (node == null) return;

        if (node.val != min && node.val < result[0]) {
            result[0] = node.val;
        }

        dfs(node.left, min, result);
        dfs(node.right, min, result);
    }
}
