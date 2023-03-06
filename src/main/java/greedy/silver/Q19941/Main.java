package greedy.silver.Q19941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String[] arr = br.readLine().split("");
        int[] h = new int[n];
        boolean[] visited = new boolean[n];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i].equals("H"))
                h[i] = 1;
            else
                h[i] = 0;
        }
        for (int i = 0; i < n; i++) {
            if (arr[i].equals("P")) {
                int start = Math.max(i-k, 0);
                int end = Math.min(i+k, n-1);
                for (int j = start; j <= end; j++) {
                    if (h[j] == 1 && !visited[j]) {
                        visited[j] = true;
                        answer++;
                        break;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
