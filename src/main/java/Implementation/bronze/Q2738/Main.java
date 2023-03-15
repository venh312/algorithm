package Implementation.bronze.Q2738;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int[][] adj1 = new int[x][y];
        int[][] adj2 = new int[x][y];
        for (int i = 0; i < x; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < y; j++)
                adj1[i][j] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < x; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < y; j++)
                adj2[i][j] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++)
                bw.write(adj1[i][j] + adj2[i][j] + " ");
            bw.write("\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
