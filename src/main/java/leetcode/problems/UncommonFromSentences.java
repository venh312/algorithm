package leetcode.problems;
/*
A sentence is a string of single-space separated words where each word consists only of lowercase letters.
A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.
Given two sentences s1 and s2, return a list of all the uncommon words. You may return the answer in any order.

Example 1:
Input: s1 = "this apple is sweet", s2 = "this apple is sour"
Output: ["sweet","sour"]

Example 2:
Input: s1 = "apple apple", s2 = "banana"
Output: ["banana"]
*/
class UncommonFromSentences {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> words = new HashMap<>();
        String[] s1Arr = s1.split(" ");
        String[] s2Arr = s2.split(" ");
        for (int i = 0; i < s1Arr.length; i++)
            words.put(s1Arr[i], words.getOrDefault(s1Arr[i], 0) + 1);
        for (int i = 0; i < s2Arr.length; i++)
            words.put(s2Arr[i], words.getOrDefault(s2Arr[i], 0) + 1);

        List<String> result = new ArrayList<>();
        words.forEach((s, integer) -> {
            if (integer == 1) {
                result.add(s);
            }
        });

        return result.toArray(new String[0]);
    }
}
