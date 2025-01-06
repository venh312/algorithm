/*
https://leetcode.com/problems/combination-sum-ii/description/

Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.
Note: The solution set must not contain duplicate combinations.

Example 1:
Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]

Example 2:
Input: candidates = [2,5,2,1,2], target = 5
Output: 
[
[1,2,2],
[5]
]
*/
class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(result, new ArrayList<>(), candidates, 0, 0, target);
        return result;
    }

    void backtrack(List<List<Integer>> result, List<Integer> list, int[] candidates, int index, int current, int target) {
        if (current == target) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) { 
                // 중복된 숫자는 건너뛴다.
                continue;
            }
            
            int val = candidates[i];
            current += val;
            if (current > target) break;
            list.add(val);
            backtrack(result, list, candidates, i+1, current, target);
            current -= list.get(list.size()-1);
            list.remove(list.size()-1);
        }
    }
}
