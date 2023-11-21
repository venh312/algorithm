import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] adj;
    static boolean[] visited;
    static void dfs(int start) {
        visited[start] = true;
        for (int i = 1; i <= N; i++)
            if (!visited[i] && adj[start][i] == 1)
                dfs(i);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adj = new int[N+1][N+1];
        visited = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u][v] = 1;
            adj[v][u] = 1;
        }

        int result = 0;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                result++;
                dfs(i);
            }
        }
        System.out.println(result);
    }

    public class SolutionGPT {
        public void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            int N = scanner.nextInt(); // 정점의 개수
            int M = scanner.nextInt(); // 간선의 개수

            ArrayList<Integer>[] graph = new ArrayList[N + 1]; // 그래프를 인접 리스트로 표현
            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }

            // 그래프에 간선 정보 추가
            for (int i = 0; i < M; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                graph[u].add(v);
                graph[v].add(u);
            }

            boolean[] visited = new boolean[N + 1]; // 방문 여부를 체크하는 배열
            int count = 0; // 연결 요소의 개수를 저장하는 변수

            // 모든 정점에 대해 DFS 수행
            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    dfs(i, graph, visited);
                    count++;
                }
            }

            System.out.println(count);
        }

        // DFS를 이용하여 연결된 정점들을 방문하고 방문 여부를 체크
        void dfs(int vertex, ArrayList<Integer>[] graph, boolean[] visited) {
            visited[vertex] = true;
            for (int neighbor : graph[vertex]) {
                if (!visited[neighbor]) {
                    dfs(neighbor, graph, visited);
                }
            }
        }
    }
}
