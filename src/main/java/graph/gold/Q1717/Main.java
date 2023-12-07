package graph.gold.Q1717;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N+1];

        // 자기 자신을 대표로 초기화
        for (int i = 1; i <= N; i++) arr[i] = i;

        // 간선 내용 체크
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (op == 0) {
                union(a, b);
            } else if (op == 1){
                if (find(a) == find(b))
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
        }

    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b)
            arr[b] = a;
    }

    private static int find(int a) {
        if (a == arr[a])
            return a;
        return arr[a] = find(arr[a]);
    }
}
