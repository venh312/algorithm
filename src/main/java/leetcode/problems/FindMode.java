package leetcode.problems;

/*
Given the root of a binary search tree (BST) with duplicates, return all the mode(s) (i.e., the most frequently occurred element) in it.
If the tree has more than one mode, return them in any order.
Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than or equal to the node's key.
The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
Both the left and right subtrees must also be binary search trees.

Example 1:
Input: root = [1,null,2,2]
Output: [2]

Example 2:
Input: root = [0]
Output: [0]
*/
class FindMode {
    // Runtime: 8 ms, faster than 21.97%
    Map<Integer,Integer> hMap = new HashMap<>();
    public int[] findMode(TreeNode root) {
        recursion(root);
        List<Integer> list = new ArrayList<>();
        int maxValue = 0;
        
        for (Integer i : hMap.keySet()) {
            int value = hMap.get(i);
            maxValue = Math.max(maxValue, value);
        }
        
        for (Integer i : hMap.keySet()) {
            int value = hMap.get(i);
            if (maxValue == value) {
                list.add(i);
            }
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public void recursion (TreeNode node) {
        if (node == null) return;
        if (node != null) {
            hMap.put(node.val, hMap.getOrDefault(node.val, 0) + 1);
        }
        recursion(node.left);
        recursion(node.right);
    }
}
