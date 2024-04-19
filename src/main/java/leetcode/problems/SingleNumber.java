package leetcode.problems;

/**
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.

Example 1:
Input: nums = [2,2,1]
Output: 1

Example 2:
Input: nums = [4,1,2,1,2]
Output: 4

Example 3:
Input: nums = [1]
Output: 1
*/
public class SingleNumber {
  /*
  이 문제는 선형 시간 복잡도(O(n))와 상수의 추가 공간을 사용하여 한 번만 나타나는 요소를 찾는 것입니다. 이러한 제약 조건 하에서 문제를 해결하기 위해서는 비트 연산을 사용할 수 있습니다.
  
  모든 요소가 두 번씩 나타나는 배열에서는 XOR(배타적 논리합) 연산을 사용하면 중복되는 요소들은 상쇄되어 결국에는 한 번만 나타나는 요소만 남게 됩니다.
  
  예를 들어, [4,1,2,1,2]의 경우를 보겠습니다.
  
  4 ^ 1 ^ 2 ^ 1 ^ 2 = 4
  */
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}
