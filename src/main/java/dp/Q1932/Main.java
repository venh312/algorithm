package dp.Q1932;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] splitArr =  br.readLine().split(" ");
            for (int j = 0; j < splitArr.length; j++)
                arr[i][j] = Integer.parseInt(splitArr[j]);
        }

        int[][] dp = new int[n][n];
        dp[0][0] = arr[0][0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + arr[i][0];
            dp[i][i] = dp[i - 1][i - 1] + arr[i][i];

            for (int j = 1; j < i; j++)
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + arr[i][j];
        }

        int maxSum = dp[n - 1][0];
        for (int i = 1; i < n; i++)
            maxSum = Math.max(maxSum, dp[n - 1][i]);

        System.out.println(maxSum);
    }
}
