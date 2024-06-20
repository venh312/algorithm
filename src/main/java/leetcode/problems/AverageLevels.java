package leetcode.prblems;

/*
Given the root of a binary tree, return the average value of the nodes on each level in the form of an array.
Answers within 10-5 of the actual answer will be accepted.

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [3.00000,14.50000,11.00000]
Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11.
Hence return [3, 14.5, 11].

Example 2:
Input: root = [3,9,20,15,7]
Output: [3.00000,14.50000,11.00000]
*/
class AverageOfLevels {
    // Runtime: 10 ms, faster than 5.45%
    public static List<Double> averageOfLevels(TreeNode root) {
        Map<Integer, List<Double>> hMap = new HashMap<>();
        findNode(root, 0, hMap);
        List<Double> result = new ArrayList<>();
        for (Map.Entry<Integer, List<Double>> entry : hMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
            List<Double> list = entry.getValue();
            double sum = list.stream().mapToDouble(Double::doubleValue).sum();
            result.add(sum / list.size());
        }
        return result;
    }

    public static void findNode(TreeNode node, int level, Map<Integer, List<Double>> hMap) {
        if (node == null) return;
        double value = node.val;

        if (hMap.containsKey(level)) {
            List <Double> list = hMap.get(level);
            list.add(value);
            hMap.put(level, list);
        } else {
            List<Double> list = new ArrayList<>();
            list.add(value);
            hMap.put(level, list);
        }

        level++;

        findNode(node.left, level, hMap);
        findNode(node.right, level, hMap);
    }

    // Runtime: 2 ms, faster than 96.17%
    public List<Double> averageOfLevels2(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            double average = sum / size;
            result.add(average);
        }

        return result;
    }
}
