/*
You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Input: root = [1,2,3,4,5,6,7]
Output: [1,#,2,3,#,4,5,6,7,#]
Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
*/
class Connect {
    public Node connect(Node root) {
        Map<Integer, List<Node>> hMap = new HashMap<>();
        connectDFS(root, 0, hMap);

        for (List<Node> list : hMap.values()) {
            int size = list.size();
            for (int i = 1; i < size; i++) {
                list.get(i-1).next = list.get(i);
            }
        }

        return root;
    }

    void connectDFS(Node root, int depth, Map<Integer, List<Node>> hMap) {
        if (root == null) return;

        List<Node> list = hMap.getOrDefault(depth, new ArrayList<>());
        list.add(root);
        hMap.put(depth, list);

        connectDFS(root.left, depth + 1, hMap);
        connectDFS(root.right, depth + 1, hMap);
    }
}
