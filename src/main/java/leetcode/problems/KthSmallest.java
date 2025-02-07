/*
Given an n x n matrix where each of the rows and columns is sorted in ascending order, return the kth smallest element in the matrix.
Note that it is the kth smallest element in the sorted order, not the kth distinct element.
You must find a solution with a memory complexity better than O(n2).

Example 1:
Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
Output: 13
Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13
*/
public class KthSmallest {
    /**
     * 주어진 행렬에서 kth 작은 원소를 반환합니다.
     *
     * @param matrix 각 행과 열이 정렬된 n x n 행렬
     * @param k      찾고자 하는 순서 (k >= 1)
     * @return kth 작은 원소
     */
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        // 행렬의 최솟값과 최댓값을 초기 탐색 범위로 설정
        int low = matrix[0][0];
        int high = matrix[n - 1][n - 1];

        // low와 high가 만날 때까지 이진 탐색 수행
        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = countLessEqual(matrix, mid);

            // mid 이하의 원소 개수가 k보다 작으면, 답은 mid보다 큰 값이어야 함
            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    /**
     * 행렬에서 target 이하인 원소의 개수를 O(n) 시간에 계산합니다.
     *
     * 알고리즘 설명:
     * - 행렬의 왼쪽 하단 (row = n-1, col = 0)에서 시작합니다.
     * - 현재 원소가 target 이하이면, 해당 열의 위쪽 모든 원소가 target 이하이므로
     *   row+1 개를 count에 더한 후 col을 증가시킵니다.
     * - 그렇지 않으면, row를 감소시켜 위쪽 원소를 검사합니다.
     *
     * @param matrix 정렬된 n x n 행렬
     * @param target 기준 값
     * @return target 이하의 원소 개수
     */
    private int countLessEqual(int[][] matrix, int target) {
        int n = matrix.length;
        int count = 0;
        int row = n - 1; // 하단 행부터 시작
        int col = 0;     // 좌측 열부터 시작

        while (row >= 0 && col < n) {
            if (matrix[row][col] <= target) {
                // 현재 열의 모든 위쪽 원소들 (0 ~ row)도 target 이하입니다.
                count += row + 1;
                col++; // 다음 열로 이동
            } else {
                row--; // 현재 원소가 target보다 크므로 위쪽 행을 검사
            }
        }
        return count;
    }
}
