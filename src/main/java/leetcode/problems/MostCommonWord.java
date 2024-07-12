package leetcode.problems;

/*
Given a string paragraph and a string array of the banned words banned,
return the most frequent word that is not banned.
It is guaranteed there is at least one word that is not banned, and that the answer is unique.

The words in paragraph are case-insensitive and the answer should be returned in lowercase.

Example 1:
Input: paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.", banned = ["hit"]
Output: "ball"
Explanation:
"hit" occurs 3 times, but it is a banned word.
"ball" occurs twice (and no other word does), so it is the
most frequent non-banned word in the paragraph.
Note that words in the paragraph are not case sensitive,
that punctuation is ignored (even if adjacent to words, such as "ball,"),
and that "hit" isn't the answer even though it occurs more because it is banned.

Example 2:
Input: paragraph = "a.", banned = []
Output: "a"
*/
class MostCommonWord {
    // Runtime: 17 ms, faster than 43.30%
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase().replaceAll("[^a-zA-Z\\s]", " ");

        String[] paragraphArr = paragraph.split("\\s+");

        if (paragraphArr.length == 1) return paragraphArr[0];

        Set<String> exclude = new HashSet<>(Arrays.asList(banned));

        Map<String, Integer> countMap = new HashMap<>();
        int maxCount = -1;
        for (String s : paragraphArr) {
            if (!exclude.contains(s)) {
                int count = countMap.getOrDefault(s, 0)+1;
                countMap.put(s, count);
                maxCount = Math.max(maxCount, count);
            }
        }

        for (Map.Entry<String, Integer> entry : countMap.entrySet())
            if (maxCount == entry.getValue()) return entry.getKey();

        return "";
    }
}
