import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;

    static int makeChessBoard(String bassPiece, int startRow, int startCol, String[][] pieces) {
        int result = 0;

        for (int i = startRow; i < (8 + startRow); i++) {
            for (int j = startCol; j < (8 + startCol); j++) {
                if (!pieces[i][j].equals(bassPiece)) result++;
                bassPiece = bassPiece.equals("B") ? "W" : "B";
            }
            bassPiece = bassPiece.equals("B") ? "W" : "B";
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        String[][] piece = new String[N][M];
        for (int i = 0; i < N; i++)
            piece[i] = br.readLine().split("");

        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                min = Math.min(min, makeChessBoard("B", i, j, piece));
                min = Math.min(min, makeChessBoard("W", i, j, piece));
            }
        }
      
        System.out.println(min);
    }
}
