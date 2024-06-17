package leetcode.problems;

/*
Given the root of an n-ary tree, return the postorder traversal of its nodes' values.
Nary-Tree input serialization is represented in their level order traversal. Each group of children is separated by the null value (See examples)

Example 1:
Input: root = [1,null,3,2,4,null,5,6]
Output: [5,6,3,2,4,1]

Example 2:
Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
Output: [2,6,14,11,7,3,12,8,4,13,9,10,5,1]
*/
class PostorderChild {
    // Runtime: 0 ms, faster than 100.00%
    List<Integer> result = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        if (root != null) {
            if (root.children == null) return null;
            for (Node node : root.children) {
                postorder(node);
            }
            result.add(root.val);
        }
        return result;
    }
}
