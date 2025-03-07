/*
Serialization is converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You need to ensure that a binary search tree can be serialized to a string, and this string can be deserialized to the original tree structure.
The encoded string should be as compact as possible.

Example 1:
Input: root = [2,1,3]
Output: [2,1,3]

Example 2:
Input: root = []
Output: []
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        inOrder(root, sb);
        return sb.toString();
    }

    private void inOrder(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        sb.append(root.val + ",");
        inOrder(root.left, sb);
        inOrder(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        for (String c : data.split(",")) {
            if (c.isEmpty()) continue;
            int value = Integer.parseInt(c);
            generateBST(value);
        }

        return root;
    }
    private TreeNode root;
    private void generateBST(int value) {
        if (root == null) root = new TreeNode(value);
        else {
            makeNode(root, value);
        }
    }
    private TreeNode makeNode(TreeNode root, int value) {
        if (root == null) return new TreeNode(value);

        if (root.val > value) {
            root.left = makeNode(root.left, value);
        } else if (root.val < value) {
            root.right = makeNode(root.right, value);
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
