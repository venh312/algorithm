/*
Given an integer n, break it into the sum of k positive integers, where k >= 2, and maximize the product of those integers.
Return the maximum product you can get.

Example 1:
Input: n = 2
Output: 1
Explanation: 2 = 1 + 1, 1 × 1 = 1.

Example 2:
Input: n = 10
Output: 36
Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
*/
class IntegerBreak {
    public int integerBreak(int n) {
        // n이 2 또는 3인 경우는 문제 조건(k >= 2)을 만족하기 위해 따로 처리합니다.
        if (n == 2) return 1;   // 2 = 1 + 1, 1 * 1 = 1
        if (n == 3) return 2;   // 3 = 1 + 2, 1 * 2 = 2
        
        // dp 배열: dp[i]는 i를 분해했을 때 만들 수 있는 최대 곱을 저장합니다.
        // 주의: dp[i]는 i 자체를 더 이상 분해하지 않고 "요소"로 사용할 때의 값을 포함합니다.
        int[] dp = new int[n + 1];
        
        // 초기값 설정: 
        // dp[1]는 1 (분해할 수 없으므로 그대로 1로 사용)
        // dp[2]와 dp[3]은 분해하는 경우가 아니라, 이후 계산 시 
        // "분해하지 않고 요소로 사용하는 경우"를 위해 자기 자신을 저장합니다.
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        
        // n이 4 이상부터는 실제 분해를 진행합니다.
        for (int i = 4; i <= n; i++) {
            int maxProduct = 0;
            // j를 i를 분할할 한 부분으로 선택하고, 나머지 i - j에 대해 dp 값을 활용합니다.
            // j를 1부터 i/2까지 선택하면, 대칭성을 활용하여 계산 횟수를 줄일 수 있습니다.
            for (int j = 1; j <= i / 2; j++) {
                int product = dp[j] * dp[i - j];
                if (product > maxProduct) {
                    maxProduct = product;
                }
            }
            dp[i] = maxProduct;
        }
        
        // 문제에서는 n을 반드시 두 개 이상의 정수로 분해해야 하므로,
        // dp 배열의 n값이 정답이 됩니다.
        return dp[n];
    }
}
