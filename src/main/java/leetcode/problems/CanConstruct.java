package leetcode.problems;

/*
Given two strings ransomNote and magazine,
return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.

Example 1:
Input: ransomNote = "a", magazine = "b"
Output: false

Example 2:
Input: ransomNote = "aa", magazine = "ab"
Output: false

Example 3:
Input: ransomNote = "aa", magazine = "aab"
Output: true
*/
class CanConstruct {
    // Runtime: 6 ms, faster than 60.77%
    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> hMap = new HashMap<>();
        int result = 0;
        for (char r : ransomNote.toCharArray()) {
            hMap.put(r, hMap.getOrDefault(r, 0) + 1);
            result++;
        }

        for (char m : magazine.toCharArray()) {
            int count = hMap.getOrDefault(m, 0);
            if (count > 0) {
                hMap.put(m, --count);
                result--;
            }
        }

        return result == 0;
    }

    // Runtime: 2 ms, faster than 80.95%
    public boolean canConstruct2(String ransomNote, String magazine) {
        // 알파벳 소문자 26개의 빈도 수를 저장할 배열
        int[] charCount = new int[26];

        // magazine의 각 문자 빈도 수 계산
        for (char c : magazine.toCharArray()) {
            charCount[c - 'a']++;
        }

        // ransomNote의 각 문자가 magazine에서 충분한지 확인
        for (char c : ransomNote.toCharArray()) {
            if (charCount[c - 'a'] == 0) {
                return false;
            }
            charCount[c - 'a']--;
        }

        return true;
    }
}
