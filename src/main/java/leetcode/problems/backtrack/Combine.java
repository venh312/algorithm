/*
https://leetcode.com/problems/combinations/

Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
You may return the answer in any order.

Example 1:
Input: n = 4, k = 2
Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
Explanation: There are 4 choose 2 = 6 total combinations.
Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.

Example 2:
Input: n = 1, k = 1
Output: [[1]]
Explanation: There is 1 choose 1 = 1 total combination.
*/
class Combine {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        combineBacktrack(result, new ArrayList<>(), n, k, 1);
        return result;
    }

    private void combineBacktrack(List<List<Integer>> result, ArrayList<Integer> list, int n, int k, int start) {
        if (k == list.size()) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <= n; i++) {
            list.add(i);
            combineBacktrack(result, list, n, k, i+1);
            list.remove(list.size()-1);
        }
    }
}
