package leetcode.problems;

/*
Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

Example 1:
Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

Example 2:
Input: numRows = 1
Output: [[1]]
*/
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        // 첫 번째 행은 항상 1
        result.add(Arrays.asList(1));
        if (numRows == 1) return result;

        // 두 번째 행은 항상 1,1
        result.add(Arrays.asList(1,1));
        if (numRows == 2) return result;

        for (int i = 2; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();

            // 현재 행의 첫 번째 값은 항상 1
            list.add(1);

            // 이전 행의 값을 이용하여 현재 행의 값을 계산
            for (int j = 1; j < i; j++) {
                int sum = result.get(i-1).get(j-1) + result.get(i-1).get(j);
                list.add(sum);
            }

            // 현재 행의 마지막 값은 항상 1
            list.add(1);

            // 현재 행을 결과 리스트에 추가
            result.add(list);
        }

        return result;
    }
}
