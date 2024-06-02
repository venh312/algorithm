package leetcode.problems;

/*
You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island. One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

Example 1:
Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
Output: 16
Explanation: The perimeter is the 16 yellow stripes in the image above.

Example 2:
Input: grid = [[1]]
Output: 4

Example 3:
Input: grid = [[1,0]]
Output: 4
*/
class IslandPerimeter {
    // Runtime: 4 ms, faster than 98.84%
    public int islandPerimeter(int[][] grid) {
        int answer = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int island = grid[i][j];
                if (island == 1) {
                    int top = i-1;
                    int bottom = i+1;
                    int left = j-1;
                    int right = j+1;
                    
                     // 위쪽 셀 확인
                    if (i == 0 || grid[top][j] == 0) {
                        answer++;
                    }
                    // 아래쪽 셀 확인
                    if (i == rows - 1 || grid[bottom][j] == 0) {
                        answer++;
                    }
                    // 왼쪽 셀 확인
                    if (j == 0 || grid[i][left] == 0) {
                        answer++;
                    }
                    // 오른쪽 셀 확인
                    if (j == cols - 1 || grid[i][right] == 0) {
                        answer++;
                    }
                }
            }
        }
        
        return answer;
    }
}
