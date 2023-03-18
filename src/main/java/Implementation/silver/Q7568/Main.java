package Implementation.silver.Q7568;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n; i++) {
            int count = 1;
            for (int j = 0; j < n; j++)
               if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1])
                   ++count;
            bw.write(count + " ");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
