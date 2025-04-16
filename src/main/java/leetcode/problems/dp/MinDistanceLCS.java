/* Delete Operation for Two Strings
https://leetcode.com/problems/delete-operation-for-two-strings/description/

Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.
In one step, you can delete exactly one character in either string.

Example 1:
Input: word1 = "sea", word2 = "eat"
Output: 2
Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".

Example 2:
Input: word1 = "leetcode", word2 = "etco"
Output: 4
*/
class MinDistanceLCS {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // LCS 테이블
        int[][] dp = new int[m + 1][n + 1];

        // DP로 LCS 길이 구하기
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int lcsLength = dp[m][n];

        return (m - lcsLength) + (n - lcsLength);
    }
}
