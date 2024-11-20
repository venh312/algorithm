/*
https://leetcode.com/problems/unique-binary-search-trees/

Given an integer n,
return the number of structurally unique BST's (binary search trees)
which has exactly n nodes of unique values from 1 to n.

Example 1:
Input: n = 3
Output: 5

Example 2:
Input: n = 1
Output: 1
 */
class NumTrees {
    /*
    dp 배열을 만들어 dp[i]가 i개의 노드로 만들 수 있는 구조적으로 독특한 이진 탐색 트리의 수를 저장합니다.
    기저 조건인 dp[0]과 dp[1]을 초기화합니다.
    i부터 n까지 각 숫자에 대해, 가능한 각 루트를 선택하고, 그 루트의 왼쪽과 오른쪽 서브트리의 트리 수를 곱하여 dp[i]에 더합니다.
    최종적으로 dp[n]이 n개의 노드로 만들 수 있는 트리의 개수를 나타냅니다.
     */
    public int numTrees(int n) {
        // dp 배열을 사용하여 가능한 트리의 수를 저장
        int[] dp = new int[n + 1];

        // 기저 조건
        dp[0] = 1; // 빈 트리 하나
        dp[1] = 1; // 하나의 노드를 가지는 트리 하나

        // n까지 반복하면서 dp 배열을 채운다
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = dp[i] + dp[j - 1] * dp[i - j]; // 0 + 1 + 1
            }
        }

        return dp[n];
    }
}
