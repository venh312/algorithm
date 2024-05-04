package leetcode.problems;

/*
Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.

You must not use any built-in exponent function or operator.

For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
 
Example 1:
Input: x = 4
Output: 2
Explanation: The square root of 4 is 2, so we return 2.
Example 2:
Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.


이 코드는 주어진 정수 x의 제곱근을 계산하는 함수인 mySqrt를 구현한 것입니다. 이 코드는 이진 탐색(Binary Search)을 사용하여 제곱근을 찾습니다.

1. 먼저, 주어진 x가 0 또는 1인 경우, 그 자체가 제곱근이므로 x를 반환합니다.
2. 그렇지 않은 경우, 이진 탐색을 시작합니다.
3. 초기에는 left를 1, right를 x로 설정하고, 결과값 result를 0으로 초기화합니다.
4. 이진 탐색을 통해 범위를 좁혀가면서 제곱근을 찾습니다.
    중간값인 mid는 left와 right의 중간값으로 설정됩니다.
    mid의 제곱이 x보다 작거나 같은 경우, mid는 현재까지의 최적해가 될 수 있습니다. 따라서 left를 mid+1로 업데이트하고 result를 mid로 설정합니다.
    그렇지 않은 경우, mid의 제곱이 x보다 크므로 mid를 범위에서 제외하고 right를 mid-1로 업데이트합니다.
5. left가 right보다 커질 때까지 이진 탐색을 반복합니다.
6. 최종적으로 result에는 x의 제곱근이 저장되어 반환됩니다.
이 코드는 이진 탐색을 사용하여 제곱근을 찾기 때문에 시간 복잡도는 O(log x)입니다. 이는 단순한 선형 탐색보다 효율적인 알고리즘입니다.
*/
public class MySqrt {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;

        int left = 1;
        int right = x;
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid <= x / mid) {
                left = mid + 1;
                result = mid;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }
}
