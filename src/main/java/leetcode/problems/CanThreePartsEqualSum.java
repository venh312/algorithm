/**
Given an array of integers arr,
return true if we can partition the array into three non-empty parts with equal sums.
정수의 배열이 주어졌을 때,
배열을 같은 합으로 빈 부분이 아닌 세 부분으로 분할할 수 있다면 true를 반환하라.

Formally, we can partition the array
if we can find indexes i + 1 < j with (arr[0] + arr[1] + ... + arr[i] == arr[i + 1] + arr[i + 2] + ... + arr[j - 1]
 == arr[j] + arr[j + 1] + ... + arr[arr.length - 1])

Example 1:
Input: arr = [0,2,1,-6,6,-7,9,1,2,0,1] => 9
Output: true
Explanation: 0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1

Example 2:
Input: arr = [0,2,1,-6,6,7,9,-1,2,0,1]
Output: false

Example 3:
Input: arr = [3,3,6,5,-2,2,5,1,-9,4]
Output: true
Explanation: 3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
*/
class CanThreePartsEqualSum {
    public boolean canThreePartsEqualSum(int[] arr) {
             // 1단계: 배열의 총합을 계산합니다.
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }
        
        // 2단계: 총합이 3으로 나누어 떨어지지 않으면 false를 반환합니다.
        if (totalSum % 3 != 0) {
            return false;
        }
        
        int targetSum = totalSum / 3; // 각 부분이 가져야 할 목표 합
        int currentSum = 0;
        int partitions = 0;
        
        // 3단계: 배열을 순회하며 부분 합을 찾고, 목표 합과 일치할 때마다 분할 카운트를 증가시킵니다.
        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];
            if (currentSum == targetSum) {
                partitions++;
                currentSum = 0;
                // 2개의 부분을 찾았고, 나머지 부분이 자동으로 만족한다고 가정할 수 있는지 확인합니다.
                if (partitions == 2) {
                    // 배열의 끝에서 목표 합이 충족되는지 확인
                    return i < arr.length - 1;
                }
            }
        }
        
        // 3개의 부분을 찾지 못한 경우 false를 반환합니다.
        return false;
    }
}
