package leetcode.problems;

/*
You are given an array of characters letters that is sorted in non-decreasing order, and a character target. There are at least two different characters in letters.

Return the smallest character in letters that is lexicographically greater than target. If such a character does not exist, return the first character in letters.

Example 1:
Input: letters = ["c","f","j"], target = "a"
Output: "c"
Explanation: The smallest character that is lexicographically greater than 'a' in letters is 'c'.

Example 2:
Input: letters = ["c","f","j"], target = "c"
Output: "f"
Explanation: The smallest character that is lexicographically greater than 'c' in letters is 'f'.

Example 3:
Input: letters = ["x","x","y","y"], target = "z"
Output: "x"
Explanation: There are no characters in letters that is lexicographically greater than 'z' so we return letters[0].
*/
class NextGreatestLetter {
    // Runtime: 0 ms, faster than 100.00%
    public char nextGreatestLetter(char[] letters, char target) {
       for (int i = 0; i < letters.length; i++) {
            if (letters[i] == target) {
                for (int j = i+1; j <= letters.length; j++) {
                    if (letters[j % letters.length] != target) {
                        return letters[j % letters.length];
                    }
                }
            } else {
                if (letters[i] > target) return letters[i];
            }
        }
        return letters[0];
    }
}
