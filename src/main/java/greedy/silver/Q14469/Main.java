package greedy.silver.Q14469;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

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
        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] > o2[0])
                return 1;
            else if (o1[0] == o2[0])
                return o1[1] - o2[1];
            return -1;
        });
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i][0] < answer)
                answer += arr[i][1];
            else
                answer = arr[i][0] + arr[i][1];
        }
        bw.write(answer + "");
        bw.flush();
        br.close();
        bw.close();
    }
}
