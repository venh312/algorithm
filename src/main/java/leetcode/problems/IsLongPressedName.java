package leetcode.problems;

/*
Your friend is typing his name into a keyboard.
Sometimes, when typing a character c,
the key might get long pressed,
and the character will be typed 1 or more times.

You examine the typed characters of the keyboard.
Return True if it is possible that it was your friends name,
with some characters (possibly none) being long pressed.

Example 1:
Input: name = "alex", typed = "aaleex"
Output: true
Explanation: 'a' and 'e' in 'alex' were long pressed.

Example 2:
Input: name = "saeed", typed = "ssaaedd"
Output: false
Explanation: 'e' must have been pressed twice, but it was not in the typed output.
*/
class IsLongPressedName {
    public boolean isLongPressedName(String name, String typed) {
      int i = 0, j = 0;  // `name`과 `typed`의 인덱스
      int n = name.length();  // `name`의 길이
      int t = typed.length(); // `typed`의 길이
      
      // `typed` 문자열을 순회하면서 `name`과 비교
      while (j < t) {
          // 현재 `name`의 문자와 `typed`의 문자가 일치하면
          if (i < n && name.charAt(i) == typed.charAt(j)) {
              i++;  // `name`의 인덱스 증가
          } else if (i > 0 && name.charAt(i - 1) == typed.charAt(j)) {
              // `typed`의 현재 문자가 `name`의 마지막 문자와 일치하면 (long press 허용)
          } else {
              // 위 조건에 맞지 않으면 `false` 반환
              return false;
          }
          j++;  // `typed`의 인덱스 증가
      }
  
      // `name`의 모든 문자를 `typed`에서 발견했는지 확인
      return i == n;  // 모든 문자가 일치하면 `true`, 그렇지 않으면 `false`
    }
}
