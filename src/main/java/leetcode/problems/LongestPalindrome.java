package leetcode.problems;

/*
Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome.

Example 1:
Input: s = "abccccdd"
Output: 7
Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.

Example 2:
Input: s = "a"
Output: 1
Explanation: The longest palindrome that can be built is "a", whose length is 1.
*/
class LongestPalindrome {
    // Runtime: 7 ms, faster than 54.04%
    public int longestPalindrome(String s) {
        // 각 문자의 등장 횟수를 기록하기 위한 맵
        Map<Character, Integer> charCount = new HashMap<>();
        
        // 문자열을 탐색하면서 각 문자의 등장 횟수를 기록
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        
        int length = 0;
        boolean oddFound = false;
        
        // 각 문자의 등장 횟수를 이용하여 회문의 길이를 계산
        for (int count : charCount.values()) {
            // 해당 문자가 홀수 번 등장하면
            if (count % 2 == 1) {
                // 이전에 홀수 번 등장한 문자를 발견했다면
                // 그 문자는 중앙에 위치하게 되므로 회문의 길이에는 1을 더함
                if (oddFound) {
                    length += count - 1;
                } else {
                    length += count;
                    oddFound = true;
                }
            } else {
                length += count;
            }
        }
        
        return length;
    }
}
