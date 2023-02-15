package greedy.silver.Q1946;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int n;

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            int answer = 1;
            StringTokenizer st;

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine()," ");
                arr[Integer.parseInt(st.nextToken()) - 1] = Integer.parseInt(st.nextToken());
            }

            if (n == 1) {
                sb.append(answer).append("\n");
                return;
            }

            int prev = arr[0];
            for (int j = 1; j < n; j++) {
                if (prev > arr[j]) {
                    prev = arr[j];
                    answer++;
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
