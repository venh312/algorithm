/*
Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
You must do it in place.
Example 1:
Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]

Example 2:
Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 */
class SetZeroes {
    int row = 0;
    int col = 0;

    public void setZeroes(int[][] matrix) {
        row = matrix.length;
        col = matrix[0].length;

        Queue<String> queue = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    System.out.println("i :" + i);
                    System.out.println("j :" + j);
                    queue.offer(i + "," + j);
                }
            }
        }

        while(!queue.isEmpty()) {
            String poll = queue.poll();
            String[] arr = poll.split(",");
            int x = Integer.parseInt(arr[0]);
            int y = Integer.parseInt(arr[1]);
            makeZeroes(matrix, x, y);
        }
    }

    public void makeZeroes(int[][] matrix, int x, int y) {
        int exmaRow = x;
        int exmaCol = y;

        for (int i = exmaRow; i >=0; i--) {
            matrix[i][exmaCol] = 0;
        }
        for (int i = exmaRow; i < row; i++) {
            matrix[i][exmaCol] = 0;
        }
        for (int i = exmaCol; i >=0; i--) {
            matrix[exmaRow][i] = 0;
        }
        for (int i = exmaCol; i < col; i++) {
            matrix[exmaRow][i] = 0;
        }
    }
  
    public void setZeroesGPT(int[][] matrix) {
         int m = matrix.length;
        int n = matrix[0].length;

        // 두 플래그로 첫 번째 행과 첫 번째 열에 0이 있는지 여부를 기록
        boolean firstRowHasZero = false;
        boolean firstColHasZero = false;

        // 첫 번째 행에 0이 있는지 확인
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRowHasZero = true;
                break;
            }
        }

        // 첫 번째 열에 0이 있는지 확인
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColHasZero = true;
                break;
            }
        }

        // 첫 번째 행과 첫 번째 열을 순회하여 0이 있는 위치를 표시
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;  // 첫 번째 열에 표시
                    matrix[0][j] = 0;  // 첫 번째 행에 표시
                }
            }
        }

        // 첫 번째 행과 첫 번째 열을 0으로 만듦
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 첫 번째 행에 대해 처리
        if (firstRowHasZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        // 첫 번째 열에 대해 처리
        if (firstColHasZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

}
