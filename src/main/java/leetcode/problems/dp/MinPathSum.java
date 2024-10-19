/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, 
which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example 1:
Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.

Example 2:
Input: grid = [[1,2,3],[4,5,6]]
Output: 12

https://leetcode.com/problems/minimum-path-sum/
*/
class MinPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length;    // 그리드의 행 수
        int n = grid[0].length; // 그리드의 열 수

        // 첫 번째 행 초기화
        for (int i = 1; i < n; i++) {
            grid[0][i] += grid[0][i - 1];
        }

        // 첫 번째 열 초기화
        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i - 1][0];
        }

        // 나머지 셀들의 최소 경로 계산
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }

        // 마지막 셀이 최소 경로 합을 저장
        return grid[m - 1][n - 1];
    }
}
