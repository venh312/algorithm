/*
https://leetcode.com/problems/game-of-life/

According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population.
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
The next state of the board is determined by applying the above rules simultaneously to every cell in the current state of the m x n grid board. In this process, births and deaths occur simultaneously.

Given the current state of the board, update the board to reflect its next state.

Note that you do not need to return anything.

Example 1:
Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
*/
public class GameOfLife {
    class Solution {
        int[][] direction = {
                {-1,-1},
                {-1,0},
                {-1,1},
                {0,-1},
                {0,1},
                {1,-1},
                {1,0},
                {1,1}
        };

        public void gameOfLife(int[][] board) {
            int rows = board.length;
            int cols = board[0].length;

            int[][] result = new int[rows][cols];

            for (int i = 0; i < rows; i++) {
                for (int k = 0; k < cols; k++) {
                    int cell = board[i][k];
                    int count = neighborsCount(board, i, k);

                    if (cell == 1 && count < 2) result[i][k] = -1;
                    else if (cell == 1 && count > 3) result[i][k] = -1;
                    else if (cell == 0 && count == 3) result[i][k] = -1;
                }
            }

            for (int i = 0; i < result.length; i++) {
                for (int k = 0; k < result[0].length; k++) {
                    if (result[i][k] == -1) {
                        if (board[i][k] == 0) board[i][k]++;
                        else board[i][k]--;
                    }
                }
            }
        }

        private int neighborsCount(int[][] board, int x, int y) {
            int count = 0;
            for (int[] ints : direction) {
                int next_x = x + ints[0];
                int next_y = y + ints[1];

                if (next_x < 0 || next_x >= board.length || next_y < 0 || next_y >= board[0].length) continue;

                if (board[next_x][next_y] == 1) count++;
            }
            return count;
        }
    }
}
