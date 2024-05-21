package leetcode.problems;

/*
Given a string s, reverse only all the vowels in the string and return it.
The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

Example 1:
Input: s = "hello"
Output: "holle"

Example 2:
Input: s = "leetcode"
Output: "leotcede"
*/
class ReverseVowels {
  public static String reverseVowels(String s) {
      Set<Character> vowels = new HashSet<>();
      vowels.add('a'); vowels.add('e'); vowels.add('i'); vowels.add('o'); vowels.add('u');
      vowels.add('A'); vowels.add('E'); vowels.add('I'); vowels.add('O'); vowels.add('U');
  
      int length = s.length();
      int left = 0, right = length-1;
  
      char[] chars = s.toCharArray();
  
      while (left < right) {
          char front = chars[left];
          char rear = chars[right];
  
          if (vowels.contains(front) && vowels.contains(rear)) {
              chars[left] = rear;
              chars[right] = front;
              left++;
              right--;
              continue;
          }
  
          if (!vowels.contains(front)) left++;
          if (!vowels.contains(rear)) right--;
      }
  
      return new String(chars);
  }
}
