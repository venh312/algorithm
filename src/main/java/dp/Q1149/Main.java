import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] cost = new int[N][3];
        int[][] dp = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++)
                cost[i][j] = Integer.parseInt(st.nextToken());
        }

        // 초기값 설정 (첫 번째 집을 각각의 색으로 칠할 때의 비용)
        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];

        for (int i = 1; i < N; i++) {
            // 빨강으로 칠할 경우, 직전 집은 초록 또는 파랑으로 칠한 경우 중 최소 비용을 선택
            dp[i][0] = cost[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            // 초록으로 칠할 경우, 직전 집은 빨강 또는 파랑으로 칠한 경우 중 최소 비용을 선택
            dp[i][1] = cost[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            // 파랑으로 칠할 경우, 직전 집은 빨강 또는 초록으로 칠한 경우 중 최소 비용을 선택
            dp[i][2] = cost[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }

        // 마지막 집을 빨강, 초록, 파랑 중에서 최소 비용으로 칠한 경우를 선택
        System.out.println(Math.min(Math.min(dp[N - 1][0], dp[N - 1][1]), dp[N - 1][2]));
    }
}
