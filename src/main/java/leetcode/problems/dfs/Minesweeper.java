/*
https://leetcode.com/problems/minesweeper/

You are given an m x n char matrix board representing the game board where:

'M' represents an unrevealed mine,
'E' represents an unrevealed empty square,
'B' represents a revealed blank square that has no adjacent mines (i.e., above, below, left, right, and all 4 diagonals),
digit ('1' to '8') represents how many mines are adjacent to this revealed square, and
'X' represents a revealed mine.

'M'은 공개되지 않은 광산을 나타냅니다,
'E'는 드러나지 않은 빈 사각형을 나타냅니다,
'B'는 인접한 지뢰(즉, 위, 아래, 왼쪽, 오른쪽, 대각선 4개 모두)가 없는 빈 사각형을 나타냅니다,
숫자('1'에서 '8')은 이 드러난 사각형에 인접한 광산의 수를 나타냅니다
'X'는 드러난 지뢰를 나타냅니다.

You are also given an integer array click where click = [clickr, clickc] represents the next click position among all the unrevealed squares ('M' or 'E').
정수 배열 클릭도 주어지는데, 여기서 클릭 = [클릭러, 클릭 c]는 모든 공개되지 않은 사각형('M' 또는 'E') 중 다음 클릭 위치를 나타냅니다.

Return the board after revealing this position according to the following rules:

1.If a mine 'M' is revealed, then the game is over. You should change it to 'X'.

2.If an empty square 'E' with no adjacent mines is revealed, then change it to a revealed blank 'B'
and all of its adjacent unrevealed squares should be revealed recursively.

3.If an empty square 'E' with at least one adjacent mine is revealed,
then change it to a digit ('1' to '8') representing the number of adjacent mines.

4.Return the board when no more squares will be revealed.

다음 규칙에 따라 이 입장을 밝힌 후 보드를 반환합니다:
1. 지뢰 'M'이 드러나면 게임이 종료됩니다. 'X'로 변경해야 합니다.

2. 인접한 지뢰가 없는 빈 사각형 'E'가 드러나면 빈 'B'로 변경합니다
그리고 인접한 모든 미공개 사각형은 재귀적으로 밝혀야 합니다.

3. 만약 인접한 광산이 하나 이상 있는 빈 사각형 'E'가 드러난다면,
그런 다음 인접한 광산의 수를 나타내는 숫자('1'에서 '8')로 변경합니다.

4. 더 이상 사각형이 드러나지 않을 때 보드를 반환합니다.

Example 1:
Input: board = [
["E","E","E","E","E"],
["E","E","M","E","E"],
["E","E","E","E","E"],
["E","E","E","E","E"]
], click = [3,0]

Output: [
["B","1","E","1","B"],
["B","1","M","1","B"],
["B","1","1","1","B"],
["B","B","B","B","B"]
]
 */
class Minesweeper {
    // DFS 방문 체크용 배열
    private boolean[][] visited;
    // 인접 8방향 (대각선 포함)
    private final int[][] directions = {
        {-1, -1}, {-1, 0}, {-1, 1},
        { 0, -1},          { 0, 1},
        { 1, -1}, { 1, 0}, { 1, 1}
    };

    public char[][] updateBoard(char[][] board, int[] click) {
        int m = board.length;
        int n = board[0].length;
        visited = new boolean[m][n];

        int clickRow = click[0];
        int clickCol = click[1];
        char clickValue = board[clickRow][clickCol];

        // 규칙 1: 클릭한 칸이 지뢰(M)라면 'X'로 변경하여 반환
        if (clickValue == 'M') {
            board[clickRow][clickCol] = 'X';
            return board;
        }

        // 클릭한 칸이 빈칸 'E'인 경우 DFS 방식으로 확인
        dfs(board, clickRow, clickCol);
        return board;
    }

    // DFS를 통해 현재 위치에서 처리
    private void dfs(char[][] board, int row, int col) {
        // 이미 방문한 칸은 넘어감
        if (visited[row][col]) {
            return;
        }
        visited[row][col] = true;

        // 현재 셀이 'E'인 경우에만 처리 (이미 열렸거나, 다른 값이면 무시)
        if (board[row][col] == 'E') {
            // 인접 8방향에서 지뢰(M)의 개수 카운트
            int mineCount = 0;
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                // 범위 체크
                if (newRow < 0 || newRow >= board.length || newCol < 0 || newCol >= board[0].length) {
                    continue;
                }
                if (board[newRow][newCol] == 'M') {
                    mineCount++;
                }
            }
            // 규칙 3: 인접 지뢰가 있는 경우, 해당 칸을 인접 지뢰 개수를 나타내는 숫자로 변경하고 재귀 중단
            if (mineCount > 0) {
                board[row][col] = (char) (mineCount + '0');
            } else {
                // 규칙 2: 인접 지뢰가 없으면 'B'로 변경하고 인접 칸을 재귀적으로 열기
                board[row][col] = 'B';
                for (int[] dir : directions) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    if (newRow < 0 || newRow >= board.length || newCol < 0 || newCol >= board[0].length) {
                        continue;
                    }
                    dfs(board, newRow, newCol);
                }
            }
        }
    }
}
