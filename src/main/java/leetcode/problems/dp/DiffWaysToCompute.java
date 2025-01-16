/*
https://github.com/venh312/algorithm/new/master/src/main/java/leetcode/problems/dp

Given a string expression of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. You may return the answer in any order.

The test cases are generated such that the output values fit in a 32-bit integer and the number of different results does not exceed 104.

Example 1:
Input: expression = "2-1-1"
Output: [0,2]
Explanation:
((2-1)-1) = 0 
(2-(1-1)) = 2

Example 2:
Input: expression = "2*3-4*5"
Output: [-34,-14,-10,-10,10]
Explanation:
(2*(3-(4*5))) = -34 
((2*3)-(4*5)) = -14 
((2*(3-4))*5) = -10 
(2*((3-4)*5)) = -10 
(((2*3)-4)*5) = 10
*/
class DiffWaysToCompute {
    public List<Integer> diffWaysToCompute(String expression) {
        // 메모이제이션을 위한 맵
        Map<String, List<Integer>> memo = new HashMap<>();
        return compute(expression, memo);
    }

    private List<Integer> compute(String expression, Map<String, List<Integer>> memo) {
        // 메모이제이션에 결과가 이미 있는 경우
        if (memo.containsKey(expression)) {
            return memo.get(expression);
        }

        List<Integer> result = new ArrayList<>();

        // 연산자가 있는지 확인하여 나눔
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            // 연산자를 기준으로 나눔
            if (c == '+' || c == '-' || c == '*') {
                // 왼쪽과 오른쪽 부분식을 재귀적으로 계산
                List<Integer> left = compute(expression.substring(0, i), memo);
                List<Integer> right = compute(expression.substring(i + 1), memo);

                // 왼쪽과 오른쪽 결과를 조합하여 결과 계산
                for (int l : left) {
                    for (int r : right) {
                        if (c == '+') {
                            result.add(l + r);
                        } else if (c == '-') {
                            result.add(l - r);
                        } else if (c == '*') {
                            result.add(l * r);
                        }
                    }
                }
            }
        }

        // 숫자만 있는 경우 결과에 추가
        if (result.isEmpty()) {
            result.add(Integer.parseInt(expression));
        }

        // 메모이제이션에 저장
        memo.put(expression, result);
        return result;
    }
}
