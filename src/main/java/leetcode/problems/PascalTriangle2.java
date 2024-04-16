package leetcode.problems;

/*
Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

Example 1:
Input: rowIndex = 3
Output: [1,3,3,1]

Example 2:
Input: rowIndex = 0
Output: [1]

Example 3:
Input: rowIndex = 1
Output: [1,1]
*/
public class PascalTriangle2 {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();

        // 첫 번째 행은 항상 1
        result.add(1);
        if (rowIndex == 0) return result;

        // 두 번째 행은 항상 1,1
        result.add(1);
        if (rowIndex == 1) return result;

        rowIndex += 1;
        for (int i = 2; i < rowIndex; i++) {
            List<Integer> list = new ArrayList<>();

            // 현재 행의 첫 번째 값은 항상 1
            list.add(1);

            // 이전 행의 값을 이용하여 현재 행의 값을 계산
            for (int j = 1; j < i; j++) {
                int sum = result.get(j-1) + result.get(j);
                list.add(sum);
            }

            // 현재 행의 마지막 값은 항상 1
            list.add(1);
            
            // 마지막 행이라면 결과 반환
            if (rowIndex == (i+1)) {
                return list;
            } else {
                // 마지막행이 아니라면 결과 갱신
                result = list;
            }
        }

        return result;
    }
}
