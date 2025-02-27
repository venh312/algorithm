/*
https://leetcode.com/problems/sort-characters-by-frequency/description/

Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.

Return the sorted string. If there are multiple answers, return any of them.

Example 1:
Input: s = "tree"
Output: "eert"
Explanation: 'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
*/
class FrequencySort {
    public String frequencySort(String s) {
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            String key = String.valueOf(c);
            frequencyMap.put(key, frequencyMap.getOrDefault(key, 0)+1);
        }

        List<Map.Entry<String,Integer>> entryList = new ArrayList<>(frequencyMap.entrySet());
        entryList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        for (Map.Entry<String, Integer> entry : entryList) {
            for (int i = 0; i < entry.getValue(); i++) {
                sb.append(entry.getKey());
            }
        }

        return sb.toString();
    }
}
