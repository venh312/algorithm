import java.lang.*;
class Solution {
    public String solution(String s) {
      StringBuilder answer = new StringBuilder();
      boolean space = true;
      for (int i = 0; i < s.length(); i++) {
          char c = s.charAt(i);
          if (c == ' ') {
              space = true;
              answer.append(c);
          } else {
              if (space) {
                  if (Character.isLetter(c)) {
                      answer.append(Character.toUpperCase(c));
                  } else {
                      answer.append(c);
                  }
                  space = false;
              } else {
                  answer.append(Character.toLowerCase(c));
              }
          }
      }
      return answer.toString();
    }
}
