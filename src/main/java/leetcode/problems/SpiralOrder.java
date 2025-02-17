/*
https://leetcode.com/problems/spiral-matrix/description/

Given an m x n matrix, return all elements of the matrix in spiral order.

Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
*/
class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
    		Map<String, Integer> directionIndexMap = new HashMap<>();
    		directionIndexMap.put("right", matrix[0].length);
    		directionIndexMap.put("down", matrix.length);
    		directionIndexMap.put("left", -1);
    		directionIndexMap.put("up", 0);
		
        List<Integer> result = new ArrayList<>();

        searchRoad(result, matrix, 0, 0, "right", directionIndexMap);

        return result;
    }
 
    void searchRoad(List<Integer> result, int[][] matrix, int x, int y, String currentDirection, Map<String, Integer> directionIndexMap) {
    		if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length) return;
    		
    		result.add(matrix[x][y]);
              
        if (currentDirection.equals("right")) y += 1;
        else if (currentDirection.equals("down")) x += 1;
        else if (currentDirection.equals("left")) y -= 1;
        else if (currentDirection.equals("up")) x -= 1;
      
    
    		if (currentDirection.equals("right")) {
    			if (y == directionIndexMap.get(currentDirection)) {
    				directionIndexMap.put(currentDirection, directionIndexMap.get(currentDirection)-1);
    				searchRoad(result, matrix, ++x, --y, "down", directionIndexMap);
    				return;
    			}
    		}
    		if (currentDirection.equals("down")) {
    			if (x == directionIndexMap.get(currentDirection)) {
    				directionIndexMap.put(currentDirection, directionIndexMap.get(currentDirection)-1);
    				searchRoad(result, matrix, --x, --y, "left", directionIndexMap);
    				return;
    			}
    		}
    		if (currentDirection.equals("left")) {
    			if (y == directionIndexMap.get(currentDirection)) {
    				directionIndexMap.put(currentDirection, directionIndexMap.get(currentDirection)+1);
    				searchRoad(result, matrix, --x, ++y, "up", directionIndexMap);
    				return;
    			}
    		}
    		if (currentDirection.equals("up")) {
    			if (x == directionIndexMap.get(currentDirection)) {
    				directionIndexMap.put(currentDirection, directionIndexMap.get(currentDirection)+1);
    				searchRoad(result, matrix, ++x, ++y, "right", directionIndexMap);
    				return;
    			}
    		}

        searchRoad(result, matrix, x, y, currentDirection, directionIndexMap);
    }

  public List<Integer> spiralOrderGPT(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int top = 0, bottom = m - 1;
        int left = 0, right = n - 1;

        while (top <= bottom && left <= right) {
            // Traverse from left to right across the top row
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            // Traverse from top to bottom along the right column
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            // Traverse from right to left along the bottom row
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // Traverse from bottom to top along the left column
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        return result;
  }
}
