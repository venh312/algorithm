/*
Given an array of distinct integers candidates and a target integer target,
return a list of all unique combinations of candidates where the chosen numbers sum to target.
You may return the combinations in any order.
서로 다른 정수 후보와 타겟 정수 타겟의 배열이 주어지면,
선택한 숫자가 타겟의 합이 되는 모든 고유한 조합의 후보 목록을 반환합니다.
조합은 어떤 순서로든 반환할 수 있습니다.

The same number may be chosen from candidates an unlimited number of times.
Two combinations are unique if the frequency of at least one of the chosen numbers is different.
후보자 중 동일한 숫자를 무제한으로 선택할 수 있습니다.
선택한 숫자 중 하나 이상의 빈도가 다른 경우 두 가지 조합이 고유합니다.

The test cases are generated such that the number of unique combinations that sum up to target
is less than 150 combinations for the given input.
테스트 케이스는 주어진 입력에 대해 최대 목표를 합산하는 고유 조합의 수가 150개 미만이 되도록 생성됩니다.

Example 1:
Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.

Example 2:
Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]

https://leetcode.com/problems/combination-sum/
*/
class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        combinationBacktrack(candidates, target, 0, results, new ArrayList<>(), 0);
        return results;
    }

    private void combinationBacktrack(int[] candidates, int target, int sum, List<List<Integer>> results,
                                      List<Integer> list, int start) {
        if (sum == target) {
            results.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (sum >= target) continue;
            sum += candidates[i];
            list.add(candidates[i]);
            combinationBacktrack(candidates, target, sum, results, list, i);
            int index = list.size() -1;
            sum -= list.get(index);
            list.remove(index);
        }
    }
}
