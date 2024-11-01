//    https://leetcode.com/problems/subsets-ii/
//    Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
//    The solution set must not contain duplicate subsets. Return the solution in any order.
//
//    Example 1:
//    Input: nums = [1,2,2]
//    Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
//
//    Example 2:
//    Input: nums = [0]
//    Output: [[],[0]]
class SubsetsWithDup {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        subsetsBacktrack(nums, new boolean[nums.length], result, new ArrayList<>(), 0);
        return result;
    }

    private void subsetsBacktrack(int[] nums, boolean[] visited, List<List<Integer>> result, ArrayList<Integer> list, int start) {
        if (list.size() <= nums.length) {
            if (!result.contains(list))
                result.add(new ArrayList<>(list));
        }

        for (int i = start; i < nums.length; i++) {
            if (visited[i]) continue;
            list.add(nums[i]);
            visited[i] = true;
            subsetsBacktrack(nums, visited, result, list, i+1);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
