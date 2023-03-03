package greedy.bronze.Q14720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;
        int index = 0;
        int[] milk = {0,1,2};
        for (int i = 0; i < n; i++) {
            int s = Integer.parseInt(st.nextToken());
            if (s == milk[index % 3]) {
                ++index;
                ++answer;
            }
        }
        System.out.println(answer);
    }
}
