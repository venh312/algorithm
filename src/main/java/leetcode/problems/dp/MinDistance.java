/*
https://leetcode.com/problems/edit-distance/

Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
You have the following three operations permitted on a word:

Insert a character
Delete a character
Replace a character

Example 1:
Input: word1 = "horse", word2 = "ros"
Output: 3

Explanation:
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')

Example 2:
Input: word1 = "intention", word2 = "execution"
Output: 5

Explanation:
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
*/
class MinDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m+1][n+1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // 문자가 같으면 추가 연산 필요 없음
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 삽입, 삭제, 대체 중 최소값 선택
                    dp[i][j] = Math.min(
                            dp[i - 1][j - 1], // 대체
                            Math.min(
                                dp[i - 1][j],   // 삭제
                                dp[i][j - 1]    // 삽입
                            )
                    ) + 1;
                }
            }
        }

        return dp[m][n];
    }
}
