package leetcode.problems;

/*
Given an array of strings words, return the words that can be typed using letters of the alphabet on only one row of American keyboard like the image below.

In the American keyboard:

the first row consists of the characters "qwertyuiop",
the second row consists of the characters "asdfghjkl", and
the third row consists of the characters "zxcvbnm".
 
Example 1:
Input: words = ["Hello","Alaska","Dad","Peace"]
Output: ["Alaska","Dad"]

Example 2:
Input: words = ["omk"]
Output: []

Example 3:
Input: words = ["adsdf","sfd"]
Output: ["adsdf","sfd"]
*/
class FindWords {
    // Runtime: 1 ms, faster than 52.99%
    public String[] findWords(String[] words) {
         // 첫 번째, 두 번째, 세 번째 줄에 있는 문자들을 집합으로 정의합니다.
        Set<Character> row1 = new HashSet<>();
        Set<Character> row2 = new HashSet<>();
        Set<Character> row3 = new HashSet<>();

        for (char c : "qwertyuiopQWERTYUIOP".toCharArray()) {
            row1.add(c);
        }
        for (char c : "asdfghjklASDFGHJKL".toCharArray()) {
            row2.add(c);
        }
        for (char c : "zxcvbnmZXCVBNM".toCharArray()) {
            row3.add(c);
        }

        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (canBeTypedInOneRow(word, row1) || canBeTypedInOneRow(word, row2) || canBeTypedInOneRow(word, row3)) {
                result.add(word);
            }
        }

        return result.toArray(new String[0]);
    }
    
    private boolean canBeTypedInOneRow(String word, Set<Character> row) {
        for (char c : word.toCharArray()) {
            if (!row.contains(c)) {
                return false;
            }
        }
        return true;
    }
}
