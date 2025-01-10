/*
https://leetcode.com/problems/number-of-islands/description/

Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:
Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1

Example 2:
Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
*/
class NumIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') { // 새로운 섬 발견
                    count++;
                    dfs(grid, i, j); // 섬의 모든 부분 탐색
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int row, int col) {
        // 범위를 벗어나거나, 현재 위치가 물('0')이라면 종료
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == '0') {
            return;
        }

        // 현재 위치를 방문 처리 ('0'으로 변경)
        grid[row][col] = '0';

        // 상하좌우 탐색
        dfs(grid, row - 1, col); // 위
        dfs(grid, row + 1, col); // 아래
        dfs(grid, row, col - 1); // 왼쪽
        dfs(grid, row, col + 1); // 오른쪽
    }
}
