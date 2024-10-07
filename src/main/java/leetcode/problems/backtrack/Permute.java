import java.util.ArrayList;
import java.util.List;

/*
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

Example 1:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Example 2:
Input: nums = [0,1]
Output: [[0,1],[1,0]]

Example 3:
Input: nums = [1]
Output: [[1]]
*/
public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> path, int[] nums) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int num : nums) {
            // 이미 path에 포함된 요소는 건너뜀
            if (path.contains(num)) continue;
            path.add(num);
            backtrack(result, path, nums);
            path.remove(path.size() - 1);  // 선택한 요소를 제거하여 다음 반복에 사용할 수 있게 함
        }
    }

    public static void main(String[] args) {
        Notepad notepad = new Notepad();
        System.out.println(notepad.permute(new int[]{1,2,3}));
    }
}
