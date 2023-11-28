package dp.Q9184;
import java.io.*;
import java.util.StringTokenizer;
public class Main {
    static int[][][] dp = new int[100][100][100];
    static int w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) return 1;
        if (a > 20 || b > 20 || c > 20) {
            if (dp[a][b][c] != 0)
                return dp[a][b][c];
            return dp[a][b][c] = w(20, 20, 20);
        }
        if (a < b && b < c) {
            if (dp[a][b][c] != 0)
                return dp[a][b][c];
            return dp[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
        }
        if (dp[a][b][c] != 0)
            return dp[a][b][c];
        return dp[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line;
        while ((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1 && c == -1) break;
            bw.write("w(" + a + ", " + b + ", " + c + ") = " + w(a, b, c) + "\n");
            bw.flush();
        }
        bw.close();
        br.close();
    }
}
