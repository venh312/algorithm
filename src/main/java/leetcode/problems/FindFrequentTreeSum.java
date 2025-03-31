/*
https://leetcode.com/problems/most-frequent-subtree-sum/

Given the root of a binary tree, return the most frequent subtree sum. If there is a tie, return all the values with the highest frequency in any order.

The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself).

Example 1:
Input: root = [5,2,-3]
Output: [2,-3,4]

Example 2:
Input: root = [5,2,-5]
Output: [2]
*/
class FindFrequentTreeSum {
    private Map<Integer, Integer> sumFrequency = new HashMap<>();
    private int maxFrequency = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) return new int[0];

        calculateSubtreeSum(root);

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : sumFrequency.entrySet()) {
            if (entry.getValue() == maxFrequency) {
                result.add(entry.getKey());
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    private int calculateSubtreeSum(TreeNode node) {
        if (node == null) return 0;

        int leftSum = calculateSubtreeSum(node.left);
        int rightSum = calculateSubtreeSum(node.right);
        int totalSum = node.val + leftSum + rightSum;

        sumFrequency.put(totalSum, sumFrequency.getOrDefault(totalSum, 0) + 1);
        maxFrequency = Math.max(maxFrequency, sumFrequency.get(totalSum));

        return totalSum;
    }
}
