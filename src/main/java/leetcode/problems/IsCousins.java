/*
Given the root of a binary tree with unique values and the values of two different
nodes of the tree x and y,
return true if the nodes corresponding to the values x and y in the tree are cousins,
or false otherwise.

고유한 값을 갖는 이진 트리의 루트와 트리 x 및 y의 서로 다른 두 노드의 값이 주어지면,
트리의 값 x 및 y에 대응하는 노드가 사촌이면 true를 반환하고, 그렇지 않으면 false를 반환한다.

Two nodes of a binary tree are cousins if they have the same depth with different parents.
이진 트리의 두 노드는 서로 다른 부모와 같은 깊이를 가지면 사촌에 해당한다.

Note that in a binary tree, the root node is at the depth 0,
and children of each depth k node are at the depth k + 1.

Example 1:
Input: root = [1,2,3,4], x = 4, y = 3
Output: false
*/
class IsCousins {
    private List<Integer> list = new ArrayList<>();
    public boolean isCousins(TreeNode root, int x, int y) {
        searchNode(root, 0, x, y, 1);
        return list.get(0) != list.get(2) && list.get(1) == list.get(3);
    }
    public void searchNode(TreeNode root, int parent, int x, int y, int depth) {
        if (root == null) return;
        searchNode(root.left, root.val, x, y, depth+1);
        searchNode(root.right, root.val, x, y, depth+1);
        if (root.val == x || root.val == y) {
            list.add(parent);
            list.add(depth);
        }
    }
}
