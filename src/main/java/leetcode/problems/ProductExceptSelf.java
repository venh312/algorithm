/*
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:
Input: nums = [1,2,3,4]
Output: [24,12,8,6]

Example 2:
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
*/
class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];  // 결과를 저장할 배열

        // Step 1: 왼쪽 곱 계산 후 answer 배열에 저장
        answer[0] = 1;  // 첫 번째 요소의 왼쪽 곱은 1 (왼쪽에 아무것도 없음)
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];  // 이전 answer 값에 nums[i-1]을 곱해 왼쪽 곱 계산
        }

        // Step 2: 오른쪽 곱 계산하면서 answer 배열 갱신
        int rightProduct = 1;  // 마지막 요소의 오른쪽 곱은 1 (오른쪽에 아무것도 없음)
        for (int i = n - 2; i >= 0; i--) {
            rightProduct *= nums[i + 1];  // 오른쪽에서 왼쪽으로 가며 곱셈 진행
            answer[i] *= rightProduct;  // 기존의 answer[i]에 오른쪽 곱을 곱해줌
        }

        return answer;  // 최종 결과 반환
    }
}
