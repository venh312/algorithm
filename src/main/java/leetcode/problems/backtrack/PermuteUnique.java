/*
https://leetcode.com/problems/permutations-ii/

Given a collection of numbers, nums, that might contain duplicates,
return all possible unique permutations in any order.
중복이 포함될 수 있는 숫자, 숫자 모음이 주어지면 가능한 모든 고유 순열을 순서대로 반환합니다.

Example 1:
Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]

Example 2:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
*/
class PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // 입력 배열을 정렬하여 중복을 쉽게 처리
        permuteBacktrack(result, new ArrayList<>(), new boolean[nums.length], nums);
        return result;
    }

    private void permuteBacktrack(List<List<Integer>> result, List<Integer> list, boolean[] visited, int[] nums) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue; // 이미 사용된 숫자는 건너뜀
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue; // 중복 처리
            list.add(nums[i]); // 현재 숫자를 추가
            visited[i] = true; // 숫자를 사용 중으로 표시
            permuteBacktrack(result, list, visited, nums);
            visited[i] = false; // 백트래킹: 사용 표시 해제
            list.remove(list.size() - 1); // 마지막 숫자 제거
        }
    }
}
