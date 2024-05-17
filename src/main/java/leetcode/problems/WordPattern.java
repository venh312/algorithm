package leetcode.problems;
/*
Given a pattern and a string s, find if s follows the same pattern.
Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.

Example 1:
Input: pattern = "abba", s = "dog cat cat dog"
Output: true

Example 2:
Input: pattern = "abba", s = "dog cat cat fish"
Output: false

Example 3:
Input: pattern = "aaaa", s = "dog cat cat dog"
Output: false

Example 4:
Input: pattern = "aaa", s = "dog dog dog dog"
Output: false
*/
class WordPattern {
    public static boolean wordPattern(String pattern, String s) {
        String[] word = s.split(" ");

        if (pattern.length() != word.length) return false;

        Map<Character, String> hMap = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            String value = hMap.getOrDefault(pattern.charAt(i), "");

            if (value.isEmpty()) {
                if (hMap.containsValue(word[i]))
                    return false;
                hMap.put(pattern.charAt(i), word[i]);
            } else {
                if (!value.equals(word[i]))
                    return false;
            }
        }

        return true;
    }
}
