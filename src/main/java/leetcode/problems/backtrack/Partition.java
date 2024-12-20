/*
https://leetcode.com/problems/palindrome-partitioning/

Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
문자열 s가 주어졌을 때, 파티션 s는 파티션의 모든 하위 문자열이 회문입니다. s의 가능한 모든 회문 분할을 반환합니다.

Example 1:
Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]

Example 2:
Input: s = "a"
Output: [["a"]]
 */
class Partition {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        int n = s.length();

        // 회문 여부를 저장할 DP 테이블
        boolean[][] dp = new boolean[n][n];

        // DP 테이블 계산 (회문 여부 미리 저장)
        for (int end = 0; end < n; end++) {
            for (int start = 0; start <= end; start++) {
                if (s.charAt(start) == s.charAt(end) && (end - start <= 2 || dp[start + 1][end - 1])) {
                    dp[start][end] = true;
                }
            }
        }

        // 백트래킹 호출
        backtrack(s, 0, new ArrayList<>(), result, dp);
        return result;
    }

    private void backtrack(String s, int start, List<String> path, List<List<String>> result, boolean[][] dp) {
        if (start == s.length()) {
            result.add(new ArrayList<>(path)); // 현재 분할 상태를 결과에 추가
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (dp[start][end]) { // 회문인 경우만 탐색
                path.add(s.substring(start, end + 1)); // 현재 문자열 추가
                backtrack(s, end + 1, path, result, dp); // 다음 분할 탐색
                path.remove(path.size() - 1); // 탐색 후 되돌리기
            }
        }
    }
}
