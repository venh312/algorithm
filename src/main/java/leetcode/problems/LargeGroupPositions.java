package leetcode.problems;

/*
In a string s of lowercase letters, these letters form consecutive groups of the same character.

For example, a string like s = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z", and "yy".

A group is identified by an interval [start, end], where start and end denote the start
and end indices (inclusive) of the group. In the above example, "xxxx" has the interval [3,6].

A group is considered large if it has 3 or more characters.

Return the intervals of every large group sorted in increasing order by start index.

예를 들어, = "abb xxxxzyy"와 같은 문자열은 그룹 "a", "bb", "xxxxx", "z" 및 "yy"를 갖습니다.

그룹은 [시작, 끝] 구간으로 식별되며, 여기서 시작과 끝은 그룹의 시작 및 끝 지수(포함)를 나타냅니다.
위의 예에서 "xxxx"는 [3,6] 구간을 갖습니다.
그룹은 3자 이상이면 큰 것으로 간주됩니다.
시작 지수별로 증가하는 순서로 정렬된 모든 큰 그룹의 간격을 반환합니다.

Example 1:
Input: s = "abbxxxxzzy"
Output: [[3,6]]
Explanation: "xxxx" is the only large group with start index 3 and end index 6.

Example 2:
Input: s = "abc"
Output: []
Explanation: We have groups "a", "b", and "c", none of which are large groups.

Example 3:
Input: s = "abcdddeeeeaabbbcd"
Output: [[3,5],[6,9],[12,14]]
Explanation: The large groups are "ddd", "eeee", and "bbb".
*/
class LargeGroupPositions {
    // Runtime: 3 ms, faster than 10.54%
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> result = new ArrayList<>();
        
        int start = 0;
        int n = s.length();
        
        while (start < n) {
            int end = start;
            while (end < n && s.charAt(end) == s.charAt(start)) {
                end++;
            }
            
            if (end - start >= 3) {
                List<Integer> interval = new ArrayList<>();
                interval.add(start);
                interval.add(end - 1);
                result.add(interval);
            }
            
            start = end;
        }
        
        return result;
    }

    // Runtime: 1 ms, faster than 100.00%
    public List<List<Integer>> largeGroupPositions2(String s) {
        List<List<Integer>> result = new ArrayList<>();
    
        int start = 0;
        int n = s.length();
    
        while (start < n) {
            int end = start;
            while (end < n && s.charAt(end) == s.charAt(start)) {
                end++;
            }
    
            if (end - start >= 3) {
                List<Integer> interval = new ArrayList<>();
                interval.add(start);
                interval.add(end - 1);
                result.add(interval);
            }
    
            start = end;
        }
    
        return result;
    }
}
