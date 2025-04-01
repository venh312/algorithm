/* 
https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/
Given an integer array nums of size n, return the minimum number of moves required to make all array elements equal.
In one move, you can increment or decrement an element of the array by 1.
Test cases are designed so that the answer will fit in a 32-bit integer.
크기 n의 정수 배열 수가 주어졌을 때, 모든 배열 요소를 동일하게 만들기 위해 필요한 최소 이동 횟수를 반환합니다.
한 번의 이동으로 배열의 요소를 1만큼 늘리거나 줄일 수 있습니다.
테스트 케이스는 답이 32비트 정수에 맞도록 설계되었습니다.

Example 1:
Input: nums = [1,2,3]
Output: 2
Explanation:
Only two moves are needed (remember each move increments or decrements one element):
[1,2,3]  =>  [2,2,3]  =>  [2,2,2]

Example 2:
Input: nums = [1,10,2,9]
Output: 16
*/
class MinMoves2 {
    /*
    모든 요소를 하나의 값으로 맞출 때 중앙값(median) 으로 맞추는 것이 이동 횟수를 최소화합니다.
    👉 중앙값을 기준으로 모든 요소를 조정하면 이동 횟수가 최소가 됩니다.
    */
    public int minMoves2(int[] nums) {
        Arrays.sort(nums); // 배열 정렬
        int median = nums[nums.length / 2]; // 중앙값 찾기
        int moves = 0;

        // 모든 요소를 median으로 변경하는 이동 횟수 계산
        for (int num : nums) {
            moves += Math.abs(num - median);
        }
        return moves;
    }
}
