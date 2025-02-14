/*
https://leetcode.com/problems/battleships-in-a-board/description/
Given an m x n matrix board where each cell is a battleship 'X' or empty '.', return the number of the battleships on board.
Battleships can only be placed horizontally or vertically on board. In other words, they can only be made of the shape 1 x k (1 row, k columns) or k x 1 (k rows, 1 column), where k can be of any size. At least one horizontal or vertical cell separates between two battleships (i.e., there are no adjacent battleships).

Example 1:
Input: board = [["X",".",".","X"],[".",".",".","X"],[".",".",".","X"]]
Output: 2

Example 2:
Input: board = [["."]]
Output: 0
*/
class CountBattleships {
    public int countBattleships(char[][] board) {
        int result = 0;

        for (int i = 0; i < board.length; i++) {
            for (int y = 0; y < board[i].length; y++) {
                if (board[i][y] == 'X') {
                    result++;
                    dfs(board, i, y);
                }
            }
        }

        return result;
    }

    void dfs(char[][] board, int x, int y) {
        if (board.length <= x || board[0].length <= y) return;
        if (board[x][y] == '.') return;
        board[x][y] = 'Y';
        dfs(board, x+1, y);
        dfs(board, x, y+1);
    }
}
