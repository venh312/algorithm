package leetcode.problems;

/*
Given the root of an n-ary tree, return the preorder traversal of its nodes' values.

Nary-Tree input serialization is represented in their level order traversal. Each group of children is separated by the null value (See examples)

Example 1:
Input: root = [1,null,3,2,4,null,5,6]
Output: [1,3,5,6,2,4]

Example 2:
Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
Output: [1,2,3,6,7,11,14,4,8,12,5,9,13,10]
*/
class PreorderChild {
    // Runtime: 29 ms
    List<Integer> result = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if (root != null) {
            System.out.print(root.val + " ");
            result.add(node.val);
            if (root.children == null) return null;
            for (Node node : root.children) {
                preorder(node);
            }
        }
        return result;
    }

    // Runtime: 3 ms, faster than 19.45
    public List<Integer> preorder2(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            result.add(curr.val);

            // Push children in reverse order to achieve preorder traversal
            if (curr.children != null) {
                for (int i = curr.children.size() - 1; i >= 0; i--) {
                    stack.push(curr.children.get(i));
                }
            }
        }

        return result;
    }
}
