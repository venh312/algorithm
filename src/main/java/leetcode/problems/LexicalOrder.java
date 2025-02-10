/*
https://leetcode.com/problems/lexicographical-numbers/description/
Given an integer n, return all the numbers in the range [1, n] sorted in lexicographical order.

You must write an algorithm that runs in O(n) time and uses O(1) extra space. 

Example 1:
Input: n = 13
Output: [1,10,11,12,13,2,3,4,5,6,7,8,9]

Example 2:
Input: n = 2
Output: [1,2]
*/
class LexicalOrder {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= 9; i++) {
            dfs(i, n, result);
        }

        return result;
    }

    private void dfs(int curr, int n, List<Integer> result) {
        if (curr > n) return;
        result.add(curr);
        for (int i = 0; i <= 9; i++) {
            int next = curr * 10 + i;
            if (next > n) return;
            dfs(next, n, result);
        }
    }
}
