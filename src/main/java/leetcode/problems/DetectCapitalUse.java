package leetcode.problems;

/*
We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital, like "Google".
Given a string word, return true if the usage of capitals in it is right.

Example 1:
Input: word = "USA"
Output: true

Example 2:
Input: word = "FlaG"
Output: false
*/
class DetectCapitalUse {
    // 2ms
    public boolean detectCapitalUse(String word) {
        String isUpperCase = word.toUpperCase();
        String isLowerCase = word.toLowerCase();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < word.length(); i++) {
            if (i == 0) {
                sb.append(Character.toUpperCase(word.charAt(i)));
            } else {
                sb.append(Character.toLowerCase(word.charAt(i)));
            }
        }
        
        return isUpperCase.equals(word) || isLowerCase.equals(word) || sb.toString().equals(word);
    }

    // 1ms  
    public boolean detectCapitalUse2(String word) {
        int n = word.length();
        if (n == 0) {
            return true;
        }
        
        // 모두 대문자인 경우
        if (allUpperCase(word)) {
            return true;
        }
        
        // 모두 소문자인 경우
        if (allLowerCase(word)) {
            return true;
        }
        
        // 첫 글자만 대문자이고 나머지는 소문자인 경우
        if (firstUpperRestLower(word)) {
            return true;
        }
        
        // 다른 경우는 대문자 사용이 올바르지 않음
        return false;
    }
    
    private boolean allUpperCase(String word) {
        for (char c : word.toCharArray()) {
            if (!Character.isUpperCase(c)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean allLowerCase(String word) {
        for (char c : word.toCharArray()) {
            if (!Character.isLowerCase(c)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean firstUpperRestLower(String word) {
        if (!Character.isUpperCase(word.charAt(0))) {
            return false;
        }
        for (int i = 1; i < word.length(); i++) {
            if (!Character.isLowerCase(word.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
