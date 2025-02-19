/*
Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears at most twice, return an array of all the integers that appears twice.
You must write an algorithm that runs in O(n) time and uses only constant auxiliary space, excluding the space needed to store the output

Example 1:
Input: nums = [4,3,2,7,8,2,3,1]
Output: [2,3]

Example 2:
Input: nums = [1,1,2]
Output: [1]

Example 3:
Input: nums = [1]
Output: []
*/
public class FindDuplicates {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> hSet = new HashSet<>();
        for (int num : nums) {
            if (!hSet.add(num)) result.add(num);
        }
        return result;
    }

    public List<Integer> findDuplicatesGPT(int[] nums) {
        List<Integer> result = new ArrayList<>();

        // 배열 순회
        for (int i = 0; i < nums.length; i++) {
            // 현재 숫자의 인덱스를 찾기 (1-based 인덱스라서 -1)
            int index = Math.abs(nums[i]) - 1;

            // 인덱스 위치의 값이 음수라면 이미 방문한 것이므로 중복
            if (nums[index] < 0) {
                result.add(index + 1);
            }

            // 해당 인덱스의 값을 음수로 변경해 방문 표시
            nums[index] = -nums[index];
        }

        return result;
    }
}
