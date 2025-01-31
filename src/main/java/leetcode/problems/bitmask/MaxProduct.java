/*
https://leetcode.com/problems/maximum-product-of-word-lengths/description/

Given a string array words, return the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. If no such two words exist, return 0.

Example 1:
Input: words = ["abcw","baz","foo","bar","xtfn","abcdef"]
Output: 16
Explanation: The two words can be "abcw", "xtfn".

Example 2:
Input: words = ["a","ab","abc","d","cd","bcd","abcd"]
Output: 4
Explanation: The two words can be "ab", "cd".

Example 3:
Input: words = ["a","aa","aaa","aaaa"]
Output: 0
Explanation: No such pair of words.
*/
class MaxProduct {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] bitmasks = new int[n]; // 각 단어의 비트마스크 저장
        int[] lengths = new int[n];  // 각 단어의 길이 저장
        
        // 각 단어를 비트마스크로 변환
        for (int i = 0; i < n; i++) {
            int bitmask = 0;
            for (char c : words[i].toCharArray()) {
                bitmask |= (1 << (c - 'a')); // 해당 알파벳의 비트를 1로 설정
            }
            bitmasks[i] = bitmask;
            lengths[i] = words[i].length();
        }

        int maxProduct = 0;

        // 두 단어를 비교하여 공통 문자가 없는 경우 길이 곱 계산
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((bitmasks[i] & bitmasks[j]) == 0) { // 공통 문자가 없을 경우
                    maxProduct = Math.max(maxProduct, lengths[i] * lengths[j]);
                }
            }
        }

        return maxProduct;
    }
}
