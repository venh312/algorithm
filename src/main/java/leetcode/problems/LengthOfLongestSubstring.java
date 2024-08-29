/**
Given a string s, find the length of the longest substring without repeating characters.
문자열이 주어졌을 때, 문자를 반복하지 않고 가장 긴 부분 문자열의 길이를 구하여라.

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/
class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();
        int left = 0; // 왼쪽 포인터
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // 현재 문자가 집합에 존재하면, 왼쪽 포인터를 이동하여 중복을 제거
            while (charSet.contains(currentChar)) {
                charSet.remove(s.charAt(left));
                left++;
            }

            // 현재 문자를 집합에 추가하고 최대 길이를 갱신
            charSet.add(currentChar);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
