/*
https://leetcode.com/problems/next-greater-element-ii/description/

Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.

The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.

Example 1:
Input: nums = [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2; 
The number 2 can't find next greater number. 
The second 1's next greater number needs to search circularly, which is also 2.

Example 2:
Input: nums = [1,2,3,4,3]
Output: [2,3,4,-1,4]
*/
class NextGreaterElements {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1); // 기본값 -1로 초기화
        Stack<Integer> stack = new Stack<>();

        // 배열을 두 바퀴 돈다고 가정하고 진행
        for (int i = 2 * n - 1; i >= 0; i--) {
            int index = i % n; // 원형 배열을 처리하기 위해 인덱스를 나머지 연산으로 계산

            // 스택의 맨 위 요소가 현재 요소보다 작거나 같으면 제거
            while (!stack.isEmpty() && stack.peek() <= nums[index]) {
                stack.pop();
            }

            // 스택의 맨 위 요소가 현재 요소보다 크다면 그 값이 정답
            if (!stack.isEmpty()) {
                result[index] = stack.peek();
            }

            // 현재 요소를 스택에 추가
            stack.push(nums[index]);
        }
        return result;
    }
}
