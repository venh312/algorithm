package greedy.silver.Q1080;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
    [0][0] ~ [N-2][M-2] 까지 두 개의 행렬을 비교하면서 다른 값이면,
    👉 3x3 크기로 1->0, 0->1 로 바꿔준다.
    모두 진행 한 후,  A, B가 다른 값이 하나라도 있다면 -1 출력
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int answer = 0;

        char[][] matrixA = new char[N][M];
        char[][] matrixB = new char[N][M];

        for (int i = 0 ; i < N ; i++) {
            String str = br.readLine();
            matrixA[i] = str.toCharArray();
        }

        for (int i = 0 ; i < N ; i++) {
            String str = br.readLine();
            matrixB[i] = str.toCharArray();
        }

        for (int i = 0 ; i < N-2 ; i++) {
            for (int j = 0 ; j < M-2 ; j++) {
                if (matrixA[i][j] == matrixB[i][j])
                    continue;

                answer++;
                for (int x = i; x < i+3; x++) {
                    for (int y = j; y < j+3 ; y++) {
                        matrixA[x][y] = matrixA[x][y] == '1' ? '0' : '1';
                    }
                }
            }
        }

        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < M ; j++) {
                if (matrixA[i][j] != matrixB[i][j]) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(answer);
    }
}
