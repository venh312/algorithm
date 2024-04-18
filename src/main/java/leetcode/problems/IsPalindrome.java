package leetcode.problems;

/**
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

Example 1:
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

Example 2:
Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.

Example 3:
Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
*/
public class IsPalindrome {
    public boolean isPalindrome(String s) {
        // 영문자와 숫자만을 골라내고 모두 소문자로 변환
        String cleanString = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        // 회문 여부를 확인
        int left = 0, right = cleanString.length() - 1;
        while (left < right) {
            if (cleanString.charAt(left) != cleanString.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean isPalindrome2(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
      	if (s.length() == 0) return true;
      	if (s.length() % 2 == 0) {
        		StringBuilder sb = new StringBuilder(s.substring(0, s.length() / 2));
        		String word = sb.toString() + sb.reverse();
        		if (word.toString().equals(s)) return true;
      	} else {
        		StringBuilder lb = new StringBuilder(s.substring(0, s.length() / 2));
        		String center = s.substring(s.length()/2, (s.length() / 2)+1);
        		String word = lb + center + lb.reverse();
        		if (word.equals(s)) return true;
      	}
      	return false;
    }
}
