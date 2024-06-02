package leetcode.problems;

/*
Given a string s, check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.

Example 1:
Input: s = "abab"
Output: true
Explanation: It is the substring "ab" twice.

Example 2:
Input: s = "aba"
Output: false

Example 3:
Input: s = "abcabcabcabc"
Output: true
Explanation: It is the substring "abc" four times or the substring "abcabc" twice.
*/
class RepeatedSubstringPattern {
    // Runtime: 34 ms, faster than 68.23%
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        
        // s의 길이의 절반까지 반복합니다.
        for (int i = 1; i <= n / 2; i++) {
            // 현재 부분 문자열 길이가 s의 전체 길이를 나눌 수 있는지 확인합니다.
            if (n % i == 0) {
                // 반복되는 부분 문자열을 생성합니다.
                String substring = s.substring(0, i);
                StringBuilder repeated = new StringBuilder();
                
                // 부분 문자열을 반복하여 새로운 문자열을 생성합니다.
                for (int j = 0; j < n / i; j++) {
                    repeated.append(substring);
                }
                
                // 생성된 문자열이 원래 문자열과 같은지 확인합니다.
                if (repeated.toString().equals(s)) {
                    return true;
                }
            }
        }
        
        // 반복되는 부분 문자열을 찾지 못한 경우 false를 반환합니다.
        return false;
    }
}
