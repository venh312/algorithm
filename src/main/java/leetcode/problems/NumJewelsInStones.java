package leetcode.problems;

/*
You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have. Each character in stones is a type of stone you have. You want to know how many of the stones you have are also jewels.
Letters are case sensitive, so "a" is considered a different type of stone from "A".

Example 1:
Input: jewels = "aA", stones = "aAAbbbb"
Output: 3

Example 2:
Input: jewels = "z", stones = "ZZ"
Output: 0
*/
class NumJewelsInStones {
    // Runtime: 1 ms, faster than 61.43%
    public int numJewelsInStones(String jewels, String stones) {
        int result = 0;
        
        Set<Character> hSet = new HashSet();
        for (char c : jewels.toCharArray()) {
            hSet.add(c);
        }
        
        for (char c : stones.toCharArray()) {
            if (hSet.contains(c)) result++;
        }
        
        return result;
    }
}
