package greedy.gold.Q2212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        if (K >= N) {
            System.out.println(0);
            return;
        }

        int[] censor = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            censor[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(censor);

        int[] dif = new int[N - 1];
        for (int i = 0; i < N - 1; i++)
            dif[i] = censor[i + 1] - censor[i];
        Arrays.sort(dif);

        System.out.println(Arrays.stream(dif).boxed().limit(N-K).mapToInt(Integer::intValue).sum());
    }
}
