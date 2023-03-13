package Implementation.silver.Q2167;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        int k = Integer.parseInt(br.readLine());
        for (int a = 0; a < k; a++) {
            answer = 0;
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for (int b = i; b <= x; b++)
                for (int c = j; c <= y; c++)
                    answer += arr[b][c];
            bw.write(answer + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
