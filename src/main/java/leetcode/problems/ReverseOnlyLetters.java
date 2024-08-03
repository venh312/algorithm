package leetcode.problems;

/*
Given a string s, reverse the string according to the following rules:

All the characters that are not English letters remain in the same position.
All the English letters (lowercase or uppercase) should be reversed.
Return s after reversing it.

Example 1:
Input: s = "ab-cd"
Output: "dc-ba"

Example 2:
Input: s = "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"

Example 3:
Input: s = "Test1ng-Leet=code-Q!"
Output: "Qedo1ct-eeLg=ntse-T!"
*/
class ReverseOnlyLetters {
    // Runtime: 1 ms, faster than 37.62%
    // Memory Usage: 41.3 MB, less than 82.55%
    public String reverseOnlyLetters(String s) {
        int length = s.length();
        int frontIndex = 0;
        int rearIndex = length - 1;
        char[] sChar = s.toCharArray();
        
        while (frontIndex < rearIndex) {
            char f = sChar[frontIndex];
            char r = sChar[rearIndex];
            
            if (Character.isLetter(f) && Character.isLetter(r)) {
                char temp = sChar[frontIndex];
                sChar[frontIndex] = sChar[rearIndex];
                sChar[rearIndex] = temp;
                frontIndex++;
                rearIndex--;
            }
            
            if (!Character.isLetter(f)) frontIndex++;
            if (!Character.isLetter(r)) rearIndex--;
        }
        
        return new String(sChar);
    }
}
