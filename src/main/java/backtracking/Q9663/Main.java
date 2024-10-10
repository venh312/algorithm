import java.io.*;
import java.util.HashSet;

/*
https://www.acmicpc.net/problem/9663

N-Queen 문제는 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다.
N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N이 주어진다. (1 ≤ N < 15)

출력
첫째 줄에 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수를 출력한다.

예제 입력 1 
8
예제 출력 1 
92
*/
public class Main {
    static int count = 0;
    public static int totalNQueens(int n) {
        boolean[] columns = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1]; // 주 대각선
        boolean[] diag2 = new boolean[2 * n - 1]; // 부 대각선
        backtrack(0, n, columns, diag1, diag2);
        return count;
    }

    private static void backtrack(int row, int n, boolean[] columns, boolean[] diag1, boolean[] diag2) {
        if (row == n) {
            count++;
            return;
        }
        for (int col = 0; col < n; col++) {
            int d1 = row - col + (n - 1); // 주 대각선 인덱스
            int d2 = row + col;           // 부 대각선 인덱스

            if (columns[col] || diag1[d1] || diag2[d2]) {
                continue;
            }
            columns[col] = true;
            diag1[d1] = true;
            diag2[d2] = true;

            backtrack(row + 1, n, columns, diag1, diag2);

            columns[col] = false;
            diag1[d1] = false;
            diag2[d2] = false;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        totalNQueens(n);

        bw.write(count + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
