package leetcode.problems;

/*
Given a string s, find the first non-repeating character in it and return its index. 
If it does not exist, return -1.

Example 1:
Input: s = "leetcode"
Output: 0

Example 2:
Input: s = "loveleetcode"
Output: 2

Example 3:
Input: s = "aabb"
Output: -1
*/
class FirstUniqChar {

  // Runtime: 38 ms, faster than 45.36%
  public int firstUniqChar(String s) {
      char[] cArr = s.toCharArray();
      Queue<Character> queue = new LinkedList<>();
      Map<Character, Integer> hMap = new HashMap<>();
  
      for (int i = 0; i < cArr.length; i++) {
          hMap.put(cArr[i], hMap.getOrDefault(cArr[i], 0) + 1);
          queue.add(cArr[i]);
      }
  
      for (int i = 0; !queue.isEmpty(); i++) {
          Character c = queue.poll();
          if (hMap.get(c) == 1) return i;
      }
  
      return -1;
  }
  
  // Runtime: 5 ms, faster than 93.36%
  public int firstUniqChar2(String s) {
      int[] cArr = new int[26];
      
      for (int i = 0; i < s.length(); i++) {
          cArr[s.charAt(i) - 'a']++;
      }
  
      for (int i = 0; i < s.length(); i++) {
          if (cArr[s.charAt(i) - 'a'] == 1) {
              return i;
          }
      }
  
      return -1;
  }
}
