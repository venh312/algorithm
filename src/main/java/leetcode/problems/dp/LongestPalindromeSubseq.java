/*
https://leetcode.com/problems/longest-palindromic-subsequence/description/

Given a string s, find the longest palindromic subsequence's length in s.
A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.
서브시퀀스는 나머지 요소의 순서를 변경하지 않고 일부 또는 전혀 요소를 삭제하여 다른 시퀀스에서 도출할 수 있는 시퀀스입니다.

Example 1:
Input: s = "bbbab"
Output: 4
Explanation: One possible longest palindromic subsequence is "bbbb".

Example 2:
Input: s = "cbbd"
Output: 2
Explanation: One possible longest palindromic subsequence is "bb".
*/
class LongestPalindromeSubseq {
  public int longestPalindromeSubseq(String s) {
    /*
    최적화 방법
    2차원 배열을 1차원 배열로 변환

    dp[i][j] 대신 **1차원 배열 dp[j]**만 사용

    이전 값을 prev 변수에 저장하여 갱신

    점화식
    s[i] == s[j]이면 dp[j] = prev + 2
    s[i] != s[j]이면 dp[j] = max(dp[j], dp[j-1])
    prev는 dp[i+1][j-1]을 저장하는 역할
     */
    int n = s.length();
    int[] dp = new int[n];

    for (int i = n - 1; i >= 0; i--) {
        int prev = 0; // dp[i+1][j-1]을 저장하는 역할
        dp[i] = 1; // 자기 자신 한 글자는 항상 팰린드롬이므로 1

        for (int j = i + 1; j < n; j++) {
            int temp = dp[j]; // dp[j] 값 보존 (다음 prev가 됨)
            if (s.charAt(i) == s.charAt(j)) {
                dp[j] = prev + 2;
            } else {
                dp[j] = Math.max(dp[j], dp[j - 1]);
            }
            prev = temp; // 이전 dp[j] 값을 prev로 업데이트
        }
    }
    return dp[n - 1];
  }
}
