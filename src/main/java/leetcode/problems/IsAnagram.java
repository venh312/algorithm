/*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
typically using all the original letters exactly once.

Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false
*/
class isAnagram {
  public boolean isAnagram(String s, String t) {
    if (t.length() != s.length())
        return false;
  
    int[] charCount = new int[26];
  
    for (int i = 0; i < s.length(); i++) {
        charCount[(s.charAt(i) - 'a')]++;
        charCount[(t.charAt(i) - 'a')]--;
    }
  
    for (int i : charCount) {
        if (i != 0) return false;
    }
  
    return true;
  }
}
