/*
https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
438. Find All Anagrams in a String
Given two strings s and p, return an array of all the start indices of p's
anagrams
in s. You may return the answer in any order.

Example 1:
Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

Example 2:
Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        int sSize = s.length();
        int pSize = p.length();

        p = sortString(p);

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < sSize; i++) {
            int cutSize = (i + pSize);
            if (cutSize <= sSize) {
                String cutString = s.substring(i, cutSize);
                cutString = sortString(cutString);
                if (p.equals(cutString)) {
                    result.add(i);
                }
            }
        }

        return result;
    }

    public List<Integer> findAnagramsGPT(String s, String p) {
        List<Integer> result = new ArrayList<>();

        // 두 문자열의 길이
        int sLen = s.length();
        int pLen = p.length();

        // p의 빈도 배열
        int[] pCount = new int[26];
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        // 현재 윈도우의 빈도 배열
        int[] sCount = new int[26];

        // s의 첫 pLen 길이 만큼 윈도우를 설정
        for (int i = 0; i < sLen; i++) {
            // 윈도우에 문자를 추가
            sCount[s.charAt(i) - 'a']++;

            // 윈도우 크기가 p의 크기보다 크면 왼쪽 끝을 뺀다.
            if (i >= pLen) {
                sCount[s.charAt(i - pLen) - 'a']--;
            }

            // 윈도우가 p와 같은 빈도 배열을 가지면 애너그램
            if (i >= pLen - 1 && isAnagram(sCount, pCount)) {
                result.add(i - pLen + 1); // 시작 인덱스
            }
        }

        return result;
    }

    // 두 배열이 같은지 비교하는 함수
    private boolean isAnagram(int[] sCount, int[] pCount) {
        for (int i = 0; i < 26; i++) {
            if (sCount[i] != pCount[i]) {
                return false;
            }
        }
        return true;
    }

    private String sortString(String s) {
        // 문자열 -> 문자 배열 변환
        char[] chars = s.toCharArray();

        // 문자 배열 정렬
        Arrays.sort(chars);

        // 정렬된 문자 배열 -> 문자열로 변환
        return new String(chars);
    }
}
