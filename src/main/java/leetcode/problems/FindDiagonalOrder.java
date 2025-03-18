/*
https://leetcode.com/problems/diagonal-traverse/

Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.
Input: mat = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,4,7,5,3,6,8,9]
*/
class FindDiagonalOrder {
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0) return new int[0];

        int m = mat.length; // 행 개수
        int n = mat[0].length; // 열 개수
        int[] result = new int[m * n]; // 결과 배열
        int row = 0, col = 0, dir = 1; // dir: 1(위로), -1(아래로)

        for (int i = 0; i < result.length; i++) {
            result[i] = mat[row][col];

            // 방향이 위쪽일 경우
            if (dir == 1) {
                if (col == n - 1) { // 오른쪽 끝 도달 시 아래로 이동
                    row++;
                    dir = -1;
                } else if (row == 0) { // 위쪽 끝 도달 시 오른쪽 이동
                    col++;
                    dir = -1;
                } else { // 기본적으로 위쪽 이동
                    row--;
                    col++;
                }
            }
            // 방향이 아래쪽일 경우
            else {
                if (row == m - 1) { // 아래쪽 끝 도달 시 오른쪽 이동
                    col++;
                    dir = 1;
                } else if (col == 0) { // 왼쪽 끝 도달 시 아래로 이동
                    row++;
                    dir = 1;
                } else { // 기본적으로 아래쪽 이동
                    row++;
                    col--;
                }
            }
        }
        return result;
    }
}
