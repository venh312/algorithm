package leetcode.problems;

/*
Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:
Input: s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"

Example 2:
Input: s = "Mr Ding"
Output: "rM gniD"
*/
class ReverseWords {
    // Runtime: 6 ms, faster than 59.71%
    public String reverseWords(String s) {
        // 문자열을 공백 기준으로 분리하여 단어 배열을 생성합니다.
        String[] words = s.split(" ");
        
        // 각 단어를 뒤집어 새로운 배열에 저장합니다.
        for (int i = 0; i < words.length; i++) {
            words[i] = new StringBuilder(words[i]).reverse().toString();
        }
        
        // 뒤집어진 단어들을 공백으로 결합하여 결과 문자열을 생성합니다.
        return String.join(" ", words);
    }
}
