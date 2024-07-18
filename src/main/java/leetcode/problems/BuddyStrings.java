package leetcode.problems;

/*
Given two strings s and goal,
return true if you can swap two letters in s so the result is equal to goal,
otherwise, return false.

Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j
and swapping the characters at s[i] and s[j].

For example, swapping at indices 0 and 2 in "abcd" results in "cbad".

두 개의 문자열과 목표가 주어지면 결과가 목표와 같도록 두 개의 문자를 바꿀 수 있으면 true를 반환하고
그렇지 않으면 false를 반환합니다.
문자 교환은 i!=j가 되고 s[i]와 s[j]의 문자를 교환하도록 두 개의 인덱스 i와 j(0-indexed)를
취하는 것으로 정의됩니다.
예를 들어, "abcd"의 인덱스 0과 2에서 스왑하면 "cbad"가 됩니다.

Example 1:
Input: s = "ab", goal = "ba"
Output: true
Explanation: You can swap s[0] = 'a' and s[1] = 'b' to get "ba", which is equal to goal.

Example 2:
Input: s = "ab", goal = "ab"
Output: false
Explanation: The only letters you can swap are s[0] = 'a' and s[1] = 'b', which results in "ba" != goal.
바꿀 수 있는 문자는 s[0] = 'a' 및 s[1] = 'b'뿐이며, 이로 인해 "ba"!= 골이 발생합니다.

Example 3:
Input: s = "aa", goal = "aa"
Output: true
Explanation: You can swap s[0] = 'a' and s[1] = 'a' to get "aa", which is equal to goal.

해석 및 해결:
s와 goal의 길이가 다르면, 문자 교환을 통해 goal을 만들 수 없으므로 false를 반환합니다.
s와 goal의 각 문자가 동일한지 확인합니다.
서로 다른 문자의 쌍이 정확히 두 개 있는지 확인하고, 그 쌍을 교환했을 때 goal이 되는지 확인합니다.
만약 s와 goal이 동일하지만 중복된 문자가 있는 경우, 교환 가능성이 있으므로 true를 반환합니다.
*/
class BuddyStrings {
    public boolean buddyStrings(String s, String goal) {
        // 문자열의 길이가 다르면 false를 반환합니다.
        if (s.length() != goal.length()) {
            return false;
        }

        // 서로 다른 문자의 쌍을 저장할 리스트입니다.
        List<Integer> diff = new ArrayList<>();

        // 문자열의 각 문자를 비교합니다.
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                diff.add(i);
            }
        }

        // 서로 다른 문자의 쌍이 정확히 두 개일 경우
        if (diff.size() == 2) {
            // 두 문자를 교환하여 goal과 동일한지 확인합니다.
            return s.charAt(diff.get(0)) == goal.charAt(diff.get(1)) &&
                    s.charAt(diff.get(1)) == goal.charAt(diff.get(0));
        }

        // 서로 다른 문자의 쌍이 없을 경우 (즉, 문자열이 동일한 경우)
        // 중복된 문자가 있는지 확인하여 교환 가능성을 판단합니다.
        if (diff.size() == 0) {
            Set<Character> uniqueChars = new HashSet<>();
            for (char c : s.toCharArray()) {
                if (!uniqueChars.add(c)) {
                    return true; // 중복된 문자가 있는 경우
                }
            }
        }

        // 그 외의 경우는 false를 반환합니다.
        return false;
    }
}
