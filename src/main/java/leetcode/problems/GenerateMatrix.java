/*
Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.

Example 1:
Input: n = 3
Output: [[1,2,3],[8,9,4],[7,6,5]]

Example 2:
Input: n = 1
Output: [[1]]
*/
class GenerateMatrix {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int num = 1;
        int left = 0, right = n - 1, top = 0, bottom = n - 1;

        while (num <= n * n) {
            // Move right
            for (int i = left; i <= right; i++) {
                matrix[top][i] = num++;
            }
            top++;  // Move down to the next row
            
            // Move down
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = num++;
            }
            right--;  // Move left to the previous column
            
            // Move left
            for (int i = right; i >= left; i--) {
                matrix[bottom][i] = num++;
            }
            bottom--;  // Move up to the previous row
            
            // Move up
            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = num++;
            }
            left++;  // Move right to the next column
        }

        return matrix;
    }
}
