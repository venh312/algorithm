/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Example 1:
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

Example 2:
Input: n = 1
Output: ["()"]
*/
class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) return result;
        backtrackParenthesis(result, "", 0, 0, n);
        return result;
    }

    private void backtrackParenthesis(List<String> result, String current, int open, int close, int max) {
        // 종료 조건: 현재 문자열의 길이가 2n이 되었을 때
        if (current.length() == 2 * max) {
            result.add(current);
            return;
        }

        // 왼쪽 괄호 추가 가능
        if (open < max) {
            backtrackParenthesis(result, current + "(", open + 1, close, max);
        }

        // 오른쪽 괄호 추가 가능
        if (close < open) {
            backtrackParenthesis(result, current + ")", open, close + 1, max);
        }
    }
}
